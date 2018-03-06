package org.bluebird.Login;

import org.bluebird.FileUtils.ConexaoBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class LoginModel {

    private Connection connection;
    private PreparedStatement stmt;
    private ResultSet rs;

    boolean usernameIsEmpty(String username) {
        return username.isEmpty();
    }

    boolean isEqual(String user1, String user2) {
        return user1.equals(user2);
    }

    private void registerAccount(String user) throws SQLException {

        this.connection = ConexaoBD.bdConnection();

        String sqlAdd = "INSERT INTO users(username, victory, defeat, tie) VALUES(?, ?, ?, ?)";
        this.stmt = this.connection.prepareStatement(sqlAdd);

        this.stmt.setString(1, user);
        this.stmt.setInt(2, 0);
        this.stmt.setInt(3, 0);
        this.stmt.setInt(4, 0);

        this.stmt.executeUpdate();

        this.stmt.close();
        this.connection.close();
    }

    private boolean accountNameExist(String user) throws SQLException {

        boolean usernameTaken;
        this.connection = ConexaoBD.bdConnection();

        String sqlRead = "SELECT username FROM users WHERE username = ?";

        this.stmt = this.connection.prepareStatement(sqlRead);
        this.stmt.setString(1, user);

        this.rs = this.stmt.executeQuery();

        usernameTaken = this.rs.next();

        this.rs.close();
        this.stmt.close();
        this.connection.close();

        return usernameTaken;
    }

    void checkAccount(String user) {
        try {
            if (!this.accountNameExist(user)) {
                this.registerAccount(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
