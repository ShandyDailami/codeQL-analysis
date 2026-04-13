import java.sql.*;

public class java_34731_JDBCQueryHandler_A01 {

    private Connection connection;

    // Constructor
    public java_34731_JDBCQueryHandler_A01() {
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "username", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to perform a SELECT query
    public ResultSet executeSelectQuery(String query) {
        try {
            Statement statement = connection.createStatement();
            return statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Method to perform a INSERT query
    public int executeInsertQuery(String query) {
        try {
            Statement statement = connection.createStatement();
            return statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    // Method to perform a DELETE query
    public int executeDeleteQuery(String query) {
        try {
            Statement statement = connection.createStatement();
            return statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    // Method to perform a UPDATE query
    public int executeUpdateQuery(String query) {
        try {
            Statement statement = connection.createStatement();
            return statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    // Main method to test our methods
    public static void main(String[] args) {
        JDBCQueryHandler jdbcQueryHandler = new JDBCQueryHandler();

        ResultSet resultSet = jdbcQueryHandler.executeSelectQuery("SELECT * FROM Users");
        while (resultSet.next()) {
            String username = resultSet.getString("username");
            String password = resultSet.getString("password");
            System.out.println("Username: " + username);
            System.out.println("Password: " + password);
        }

        int rowsInserted = jdbcQueryHandler.executeInsertQuery("INSERT INTO Users (username, password) VALUES ('testuser', 'testpassword')");
        System.out.println("Rows inserted: " + rowsInserted);

        int rowsUpdated = jdbcQueryHandler.executeUpdateQuery("UPDATE Users SET password = 'newpassword' WHERE username = 'testuser'");
        System.out.println("Rows updated: " + rowsUpdated);

        int rowsDeleted = jdbcQueryHandler.executeDeleteQuery("DELETE FROM Users WHERE username = 'testuser'");
        System.out.println("Rows deleted: " + rowsDeleted);
    }
}