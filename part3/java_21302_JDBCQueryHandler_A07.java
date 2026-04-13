import java.sql.*;
import java.util.*;

public class java_21302_JDBCQueryHandler_A07 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private static Connection connection;

    public static void main(String[] args) {
        // Establish the database connection
        establishConnection();

        // Run queries
        runQueries();

        // Close the connection
        closeConnection();
    }

    private static void establishConnection() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void runQueries() {
        String query1 = "SELECT * FROM users WHERE email = ?";
        String query2 = "UPDATE users SET password = ? WHERE email = ?";

        try {
            PreparedStatement statement1 = connection.prepareStatement(query1);
            statement1.setString(1, "test@test.com");

            int rowsUpdated1 = statement1.executeUpdate();
            System.out.println("Number of rows updated in query 1: " + rowsUpdated1);

            PreparedStatement statement2 = connection.prepareStatement(query2);
            statement2.setString(1, "newpassword");
            statement2.setString(2, "test@test.com");

            int rowsUpdated2 = statement2.executeUpdate();
            System.out.println("Number of rows updated in query 2: " + rowsUpdated2);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}