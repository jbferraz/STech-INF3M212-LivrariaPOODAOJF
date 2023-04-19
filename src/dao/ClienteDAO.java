/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.Cliente;

/**
 *
 * @author jbferraz
 */
public class ClienteDAO {

    public void cadastrarClienteDAO(Cliente cVO) {
        try {
            //busca conexão com o BD
            Connection con = Conexao.getConexao();
            //cria espaço de trabalho SQl, é a área no Java onde
            //vamo executar os scripts SQL
            String sql;
            sql = "insert into clientes values (null, ?,?,null,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, cVO.getNomeCliente());
            pst.setString(2, cVO.getCpf());
            pst.setString(3, cVO.getEndereco());
            pst.setString(4, cVO.getTelefone());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao cadastrar!\n"
                    + ex.getMessage());
        }
    }//fim cadastrar

    public ArrayList<Cliente> getClientesDAO() {
        ArrayList<Cliente> clientes = new ArrayList<>();
        try {
            Connection con = Conexao.getConexao();
            Statement stat = con.createStatement();
            String sql = "select * from clientes";
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                Cliente c = new Cliente();
                //lado do java |x| (lado do banco)
                c.setIdCliente(rs.getInt("idcliente"));
                c.setNomeCliente(rs.getString("nome"));
                c.setCpf(rs.getString("cpf"));
                c.setEndereco(rs.getString("endereco"));
                c.setTelefone(rs.getString("telefone"));
                clientes.add(c);
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao Listar!\n"
                    + ex.getMessage());
        }
        return clientes;
    }//fim do listar

    public Cliente getClienteByDoc(String cpf) {
        Cliente c = new Cliente();
        try {
            Connection con = Conexao.getConexao();
            String sql = "select * from clientes where cpf = ?;";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, cpf);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                //lado do java |x| (lado do banco)
                c.setIdCliente(rs.getInt("idcliente"));
                c.setNomeCliente(rs.getString("nome"));
                c.setCpf(rs.getString("cpf"));
                c.setEndereco(rs.getString("endereco"));
                c.setTelefone(rs.getString("telefone"));
            }
        } catch (SQLException ex) {
            System.out.println("Erro ao consultar CPF!\n"
                    + ex.getMessage());
        }
        return c;
    }

    public void deletarClienteDAO(String cpf) {
        try {
            Connection con = Conexao.getConexao();
            String sql = "delete from clientes where cpf = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, cpf);
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao deletar CPF!\n"
                    + ex.getMessage());
        }
    }//fim deletarCliente

    public void atualizaClienteByDoc(Cliente cVO) {
        try {
            Connection con = Conexao.getConexao();
            String sql = "update clientes set nome = ?, endereco = ?, telefone = ? "
                    + "where cpf = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, cVO.getNomeCliente());
            pst.setString(2, cVO.getEndereco());
            pst.setString(3, cVO.getTelefone());
            pst.setString(4, cVO.getCpf());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Erro ao atualizar CPF!\n"
                    + ex.getMessage());
        }
    }
}
