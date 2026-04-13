import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.c3p0.C3p0PooledConnection;

public class java_21604_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private static final String SELECT_QUERY = "SELECT * FROM Users";

    public static void main(String[] args) {
        C3p0PooledConnection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create connection pool
            connection = new C3p0PooledConnection(URL, USER, PASSWORD);

            // Create Statement
            statement = connection.prepareStatement(SELECT_QUERY);

            // Execute Query
            resultSet = statement.executeQuery();

            // Process ResultSet
            while (resultSet.next()) {
                System.out.println("User ID: " + resultSet.getString("UserID"));
                System.out.println("User Name: " + resultSet.getString("UserName"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close Connection, Statement and ResultSet
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}