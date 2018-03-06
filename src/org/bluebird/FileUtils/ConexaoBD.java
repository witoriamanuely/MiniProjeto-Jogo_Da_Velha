package org.bluebird.FileUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {

    private static final String SQCONN = "jdbc:sqlite:JogoDaVelhaStats.db";

    public static Connection bdConnection() {

        Connection connection = null;

        try {
            connection = ConexaoBD.returnConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (connection == null) {
            System.err.println("Conexão com bando de dados não encontrada");
            System.exit(1);
        }

        return connection;
    }

    private static Connection returnConnection() throws SQLException {

        try {
            Class.forName("org.sqlite.JDBC");
            return DriverManager.getConnection(SQCONN);
        } catch (ClassNotFoundException error) {
            error.printStackTrace();
            return null;
        }
    }
}
