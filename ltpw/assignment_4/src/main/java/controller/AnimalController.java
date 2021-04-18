/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AnimalDAO;
import extensions.StringExtensions;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.AnimalModel;

/**
 *
 * @author devwarlt
 */
public class AnimalController extends HttpServlet {

    private static final String DADOS_INVALIDOS_JSP = "DadosInvalidos.jsp";
    private static final String APROVADO_JSP = "Aprovado.jsp";
    private static final String REPROVADO_JSP = "Reprovado.jsp";
    private static final float MEDIA = 6.0F;

    private RequestDispatcher createDispatcher(HttpServletRequest request, String path) {
        RequestDispatcher dispatcher = request.getRequestDispatcher(path);
        return dispatcher;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher;
        String action = request.getParameter("action");
        if (StringExtensions.isNullOrWhitespace(action)) {
            request.setAttribute("status", 500);
            request.setAttribute("message", "É necessário fornecer uma ação para o controlador.");
            dispatcher = this.createDispatcher(request, "index.jsp");
        } else {
            if ("read".equals(action)) {
                String source = request.getParameter("source");
                if (StringExtensions.isNullOrWhitespace(source)) {
                    request.setAttribute("status", 500);
                    request.setAttribute("message", "É necessário uma fonte de redirecionamento para a requisição.");
                    dispatcher = this.createDispatcher(request, "index.jsp");
                } else {
                    String idStr = request.getParameter("id_animal");
                    if (StringExtensions.isNullOrWhitespace(idStr)) {
                        request.setAttribute("status", 403);
                        request.setAttribute("message", "ID inválido para ação de consulta.");
                        dispatcher = this.createDispatcher(request, "index.jsp");
                    } else {
                        try {
                            int id = Integer.parseInt(idStr);
                            AnimalDAO dao = new AnimalDAO();
                            AnimalModel model = dao.consultarAnimal(id);
                            request.setAttribute("id_animal", model.getId());
                            request.setAttribute("nome_animal", model.getNome());
                            request.setAttribute("nome_dono", model.getDono());
                            request.setAttribute("especie", model.getEspecie());
                            request.setAttribute("raca", model.getRaca());
                            request.setAttribute("sexo", model.getSexo());
                            dispatcher = this.createDispatcher(request, source);
                        } catch (SQLException ex) {
                            Logger.getLogger(AnimalController.class.getName()).log(Level.SEVERE, null, ex);
                            request.setAttribute("status", 500);
                            request.setAttribute("message", "Não foi possível obter o resultado da operação da consulta.");
                            dispatcher = this.createDispatcher(request, "index.jsp");
                        }
                    }
                }
            } else {
                request.setAttribute("status", 404);
                request.setAttribute("message", "Ação não encontrada no controlador.");
                dispatcher = this.createDispatcher(request, "index.jsp");
            }
        }

        dispatcher.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher;
        String action = request.getParameter("action");
        if (StringExtensions.isNullOrWhitespace(action)) {
            request.setAttribute("status", 500);
            request.setAttribute("message", "É necessário fornecer uma ação para o controlador.");
            dispatcher = this.createDispatcher(request, "index.jsp");
        } else {
            switch (action) {
                case "create":
                    dispatcher = this.createAction(request);
                    break;

                case "update":
                    dispatcher = this.updateAction(request);
                    break;

                case "delete":
                    dispatcher = this.deleteAction(request);
                    break;

                default: {
                    request.setAttribute("status", 404);
                    request.setAttribute("message", "Ação não encontrada no controlador.");
                    dispatcher = this.createDispatcher(request, "index.jsp");
                }
                break;
            }
        }

        dispatcher.forward(request, response);
    }

    private RequestDispatcher createAction(HttpServletRequest request) {
        String nome = request.getParameter("nome_animal");
        String dono = request.getParameter("nome_dono");
        String especie = request.getParameter("especie");
        String raca = request.getParameter("raca");
        String sexo = request.getParameter("sexo");
        if (StringExtensions.isNullOrEmpty(nome)
                || StringExtensions.isNullOrEmpty(dono)
                || StringExtensions.isNullOrEmpty(especie)
                || StringExtensions.isNullOrEmpty(raca)
                || StringExtensions.isNullOrEmpty(sexo)) {
            request.setAttribute("status", 500);
            request.setAttribute("message", "Dados para cadastro de um novo animal inválidos.");
            return this.createDispatcher(request, "index.jsp");
        }

        AnimalDAO dao = new AnimalDAO();
        AnimalModel model = new AnimalModel();
        model.setNome(nome);
        model.setDono(dono);
        model.setEspecie(especie);
        model.setRaca(raca);
        model.setSexo(sexo);
        try {
            if (dao.criarAnimal(model)) {
                request.setAttribute("status", 200);
                request.setAttribute("message", "Dados cadastrados do animal foram incluidos com sucesso!");
                return this.createDispatcher(request, "index.jsp");
            } else {
                request.setAttribute("status", 500);
                request.setAttribute("message", "Não foi possível consultar os dados do animal.");
                return this.createDispatcher(request, "index.jsp");
            }
        } catch (SQLException ex) {
            Logger.getLogger(AnimalController.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("status", 500);
            request.setAttribute("message", "Não foi possível obter o resultado da operação de criação.");
            return this.createDispatcher(request, "index.jsp");
        }
    }

    private RequestDispatcher updateAction(HttpServletRequest request) {
        String idStr = request.getParameter("id_animal");
        String nome = request.getParameter("nome_animal");
        String dono = request.getParameter("nome_dono");
        String especie = request.getParameter("especie");
        String raca = request.getParameter("raca");
        String sexo = request.getParameter("sexo");
        if (StringExtensions.isNullOrEmpty(idStr)
                || StringExtensions.isNullOrEmpty(nome)
                || StringExtensions.isNullOrEmpty(dono)
                || StringExtensions.isNullOrEmpty(especie)
                || StringExtensions.isNullOrEmpty(raca)
                || StringExtensions.isNullOrEmpty(sexo)) {
            request.setAttribute("status", 500);
            request.setAttribute("message", "Dados para atualização do animal inválidos.");
            return this.createDispatcher(request, "index.jsp");
        }

        AnimalDAO dao = new AnimalDAO();

        try {
            AnimalModel model = new AnimalModel();
            model.setNome(nome);
            model.setDono(dono);
            model.setEspecie(especie);
            model.setRaca(raca);
            model.setSexo(sexo);
            model.setId(Integer.parseInt(idStr));

            if (dao.atualizarAnimal(model)) {
                request.setAttribute("status", 200);
                request.setAttribute("message", "Dados cadastrados do animal foram atualizados com sucesso!");
                return this.createDispatcher(request, "index.jsp");
            } else {
                request.setAttribute("status", 500);
                request.setAttribute("message", "Não foi possível atualizar os dados do animal.");
                return this.createDispatcher(request, "index.jsp");
            }
        } catch (NumberFormatException | SQLException ex) {
            Logger.getLogger(AnimalController.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("status", 500);
            request.setAttribute("message", "Não foi possível obter o resultado da operação de atualização.");
            return this.createDispatcher(request, "index.jsp");
        }
    }

    private RequestDispatcher deleteAction(HttpServletRequest request) {
        String idStr = request.getParameter("id_animal");
        if (StringExtensions.isNullOrEmpty(idStr)) {
            request.setAttribute("status", 500);
            request.setAttribute("message", "Dados para remoção do animal inválidos.");
            return this.createDispatcher(request, "index.jsp");
        }

        AnimalDAO dao = new AnimalDAO();

        try {
            int id = Integer.parseInt(idStr);
            if (dao.removerAnimal(id)) {
                request.setAttribute("status", 200);
                request.setAttribute("message", "Dados cadastrados do animal foram removidos com sucesso!");
                return this.createDispatcher(request, "index.jsp");
            } else {
                request.setAttribute("status", 500);
                request.setAttribute("message", "Não foi possível remover os dados do animal.");
                return this.createDispatcher(request, "index.jsp");
            }
        } catch (NumberFormatException | SQLException ex) {
            Logger.getLogger(AnimalController.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("status", 500);
            request.setAttribute("message", "Não foi possível obter o resultado da operação de remoção.");
            return this.createDispatcher(request, "index.jsp");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Controller para a validação das notas.";
    }// </editor-fold>

}
