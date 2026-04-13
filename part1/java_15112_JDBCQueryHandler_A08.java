import java.sql.*;

public class java_15112_JDBCQueryHandler_A08 {

    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private Connection connection;

    public java_15112_JDBCQueryHandler_A08() {
        connect();
    }

    private void connect() {
        try {
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to database successfully!");
        } catch (SQLException e) {
            System.out.println("Failed to connect to database!");
            e.printStackTrace();
            System.exit(1);
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            return result;
        } catch (SQLException e) {
            System.out.println("Error executing query: " + query);
            e.printStackTrace();
            return null;
        }
    }

    public int executeUpdate(String query) {
        try {
            Statement statement = connection.createStatement();
            int result = statement.executeUpdate(query);
            return result;
        } catch (SQLException e) {
            System.out.println("Error executing query: " + query);
            e.printStackTrace();
            return -1;
        }
    }

    public void closeConnection() {
        try {
            connection.close();
            System.out.println("Connection closed successfully!");
        } catch (SQLException e) {
            System.out.println("Failed to close connection!");
            e.printStackTrace();
        }
    }
}