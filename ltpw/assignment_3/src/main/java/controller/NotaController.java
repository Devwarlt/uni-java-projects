/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import extensions.StringExtensions;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.NotaModel;

/**
 *
 * @author devwarlt
 */
public class NotaController extends HttpServlet {

    private static final String DADOS_INVALIDOS_JSP = "DadosInvalidos.jsp";
    private static final String APROVADO_JSP = "Aprovado.jsp";
    private static final String REPROVADO_JSP = "Reprovado.jsp";
    private static final float MEDIA = 6.0F;

    private RequestDispatcher createDispatcher(HttpServletRequest request, String path) {
        RequestDispatcher dispatcher = request.getRequestDispatcher(path);
        return dispatcher;
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NotaController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet NotaController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        processRequest(request, response);
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
        String nota1 = request.getParameter("nota1");
        String nota2 = request.getParameter("nota2");
        String nota3 = request.getParameter("nota3");
        if (StringExtensions.isNullOrWhitespace(nota1)
                || StringExtensions.isNullOrWhitespace(nota2)
                || StringExtensions.isNullOrWhitespace(nota3)) {
            dispatcher = this.createDispatcher(request, DADOS_INVALIDOS_JSP);
        } else {
            NotaModel notaModel = new NotaModel(
                    Integer.parseInt(nota1),
                    Integer.parseInt(nota2),
                    Integer.parseInt(nota3));
            float media = notaModel.calculaMedia();
            dispatcher = media > MEDIA
                    ? this.createDispatcher(request, APROVADO_JSP)
                    : this.createDispatcher(request, REPROVADO_JSP);
            DecimalFormat decimalFormat = new DecimalFormat("0.00");
            request.setAttribute("media", decimalFormat.format(media));
        }

        dispatcher.forward(request, response);
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
