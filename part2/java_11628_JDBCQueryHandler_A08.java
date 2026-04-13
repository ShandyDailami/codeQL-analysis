import java.sql.*;

public class java_11628_JDBCQueryHandler_A08 {
    // Define your database connection here
    private static final String URL = "jdbc:mysql://localhost:3306/your_database";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    // Create a connection to the database
    private Connection connection;

    public java_11628_JDBCQueryHandler_A08() {
        initializeConnection();
    }

    private void initializeConnection() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Error while connecting to the database");
            e.printStackTrace();
        }
    }

    // Start a transaction
    public void startTransaction() {
        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            System.out.println("Error while starting transaction");
            e.printStackTrace();
        }
    }

    // Commit a transaction
    public void commit() {
        try {
            connection.commit();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            System.out.println("Error while committing transaction");
            e.printStackTrace();
        }
    }

    // Rollback a transaction
    public void rollback() {
        try {
            connection.rollback();
            connection.setAutoCommit(true);
        } catch (SQLException e) {
            System.out.println("Error while rolling back transaction");
            e.printStackTrace();
        }
    }

    // Execute a SELECT query
    public ResultSet executeQuery(String query) {
        startTransaction();
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            commit();
            return result;
        } catch (SQLException e) {
            rollback();
            System.out.println("Error while executing query");
            e.printStackTrace();
        }
        return null;
    }

    // Execute an INSERT, UPDATE or DELETE query
    public void executeUpdate(String query) {
        startTransaction();
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.executeUpdate();
            commit();
        } catch (SQLException e) {
            rollback();
            System.out.println("Error while executing update or delete query");
            e.printStackTrace();
        }
    }
}