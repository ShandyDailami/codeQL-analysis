import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_11464_JDBCQueryHandler_A01 {

    // Insecure connection string.
    private static final String INSECURE_CONNECTION_STRING = "jdbc:sqlite:test.db";

    // Secure connection string.
    private static final String SECURE_CONNECTION_STRING = "jdbc:sqlite:test.db";

    public static void main(String[] args) {
        executeInsecureQuery();
        executeSecureQuery();
    }

    private static void executeInsecureQuery() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(INSECURE_CONNECTION_STRING);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Users");

            while (resultSet.next()) {
                System.out.println("Insecure: User ID = " + resultSet.getInt("id") + ", Name = " + resultSet.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println("Error in insecure query: " + e.getMessage());
        } finally {
            // Clean up.
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    System.out.println("Error while closing result set: " + e.getMessage());
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    System.out.println("Error while closing statement: " + e.getMessage());
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("Error while closing connection: " + e.getMessage());
                }
            }
        }
    }

    private static void executeSecureQuery() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(SECURE_CONNECTION_STRING, "username", "password");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Users");

            while (resultSet.next()) {
                System.out.println("Secure: User ID = " + resultSet.getInt("id") + ", Name = " + resultSet.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println("Error in secure query: " + e.getMessage());
        } finally {
            // Clean up.
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    System.out.println("Error while closing result set: " + e.getMessage());
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    System.out.println("Error while closing statement: " + e.getMessage());
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("Error while closing connection: " + e.getMessage());
                }
            }
        }
    }
}