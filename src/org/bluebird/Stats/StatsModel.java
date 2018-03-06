package org.bluebird.Stats;

import org.bluebird.FileUtils.ConexaoBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class StatsModel {
    int[] returnStats(String user) throws SQLException {
        Connection connection;
        PreparedStatement stmt;
        ResultSet rs;
        int[] stats = new int[3];

        connection = ConexaoBD.bdConnection();

        String sqlRead = "SELECT victory, defeat, tie FROM users WHERE username = ?";

        stmt = connection.prepareStatement(sqlRead);
        stmt.setString(1, user);

        rs = stmt.executeQuery();

        stats[0] = rs.getInt("victory");
        stats[1] = rs.getInt("defeat");
        stats[2] = rs.getInt("tie");

        rs.close();
        stmt.close();
        connection.close();

        return stats;
    }
}
