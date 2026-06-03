package Banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private Connection con;

    public Conexao(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/registro_de_treino", "root", "root");

            System.out.println("Conexão efetuada com sucesso!");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Falha na conexão");
            e.printStackTrace();
        }
    }

    public Connection getCon() {
        return con;
    }

    public static void main(String[] args) {
        Conexao c = new Conexao();
    }
}