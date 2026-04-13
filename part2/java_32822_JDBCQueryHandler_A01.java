import java.sql.*;

public class java_32822_JDBCQueryHandler_A01 {

    // DB credentials
    private static final String DB_USERNAME = "your_username";
    private static final String DB_PASSWORD = "your_password";
    private static final String DB_URL = "jdbc:mysql://your_host:your_port/your_database";

    private Connection connection;

    public java_32822_JDBCQueryHandler_A01() {
        establishConnection();
    }

    // Establish the connection
    private void establishConnection() {
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            System.out.println("Connection established successfully!");
        } catch (SQLException e) {
            System.out.println("Failed to establish connection: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Execute a query
    public void executeQuery(String query) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            // Print the results
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Name: " + resultSet.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println("Failed to execute query: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Close the connection
    public void closeConnection() {
        try {
            connection.close();
            System.out.println("Connection closed successfully!");
        } catch (SQLException e) {
            System.out.println("Failed to close connection: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        handler.executeQuery("SELECT * FROM your_table");
        handler.closeConnection();
    }
}