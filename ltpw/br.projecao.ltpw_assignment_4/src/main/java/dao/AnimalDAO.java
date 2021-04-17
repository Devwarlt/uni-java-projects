/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.AnimalModel;

/**
 *
 * @author devwarlt
 */
public final class AnimalDAO {

    private static final String URI = "jdbc:mysql://localhost:3306/dbpetshop";
    private static final String USER = "root";
    private static final String PASS = "";

    private static Connection criarConexao() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(URI, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Não foi possível estabelecer uma conexão ao "
                    + "banco de dados MySQL.\n"
                    + "- Stacktrace:\n" + e);
            return null;
        }
    }

    public boolean criarAnimal(AnimalModel model) throws SQLException {
        Connection conexao = criarConexao();
        if (conexao == null) {
            return false;
        }

        try {
            String query = "INSER INTO `animal`"
                    + " (`nomeAnimal`, `nomeDono`, `especie`, `raca`, `sexo`)"
                    + " VALUES(?, ?, ?, ?, ?);";
            PreparedStatement statement = conexao.prepareStatement(query);
            statement.setString(1, model.getNome());
            statement.setString(2, model.getDono());
            statement.setString(3, model.getEspecie());
            statement.setString(4, model.getRaca());
            statement.setString(5, model.getSexo());
            statement.execute();
            return true;
        } catch (SQLException e) {
            return false;
        } finally {
            conexao.close();
        }
    }

    public AnimalModel consultarAnimal(int id) throws SQLException {
        Connection conexao = criarConexao();
        if (conexao == null) {
            return null;
        }

        try {
            String query = "SELECT * FROM `animal` WHERE `id`=?;";
            PreparedStatement statement = conexao.prepareStatement(query);
            statement.setInt(1, id);
            statement.execute();

            ResultSet result = statement.executeQuery();
            if (!result.next()) {
                return null;
            }

            AnimalModel model = new AnimalModel();
            model.setId(result.getInt("idAnimal"));
            model.setNome(result.getString("nomeAnimal"));
            model.setDono(result.getString("nomeDono"));
            model.setEspecie(result.getString("especie"));
            model.setRaca(result.getString("raca"));
            model.setSexo(result.getString("sexo"));
            return model;
        } catch (SQLException e) {
            return null;
        } finally {
            conexao.close();
        }
    }

    public boolean atualizarAnimal(AnimalModel model) throws SQLException {
        Connection conexao = criarConexao();
        if (conexao == null) {
            return false;
        }

        try {
            String query = "UPDATE `animal` SET "
                    + "`nomeAnimal`=?, "
                    + "`nomeDono`=?, "
                    + "`especie`=?, "
                    + "`raca`=?, "
                    + "`sexo`=? "
                    + "WHERE `id`=?;";
            PreparedStatement statement = conexao.prepareStatement(query);
            statement.setString(1, model.getNome());
            statement.setString(2, model.getDono());
            statement.setString(3, model.getEspecie());
            statement.setString(4, model.getRaca());
            statement.setString(5, model.getSexo());
            statement.setInt(6, model.getId());
            statement.execute();
            return true;
        } catch (SQLException e) {
            return false;
        } finally {
            conexao.close();
        }
    }

    public boolean removerAnimal(int id) throws SQLException {
        Connection conexao = criarConexao();
        if (conexao == null) {
            return false;
        }

        try {
            String query = "DELETE FROM `animal` WHERE `id`=?;";
            PreparedStatement statement = conexao.prepareStatement(query);
            statement.setInt(1, id);
            statement.execute();
            return true;
        } catch (SQLException e) {
            return false;
        } finally {
            conexao.close();
        }
    }
}
