import java.sql.*;

public class java_41772_JDBCQueryHandler_A08 {
    private static final String url = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String username = "root";
    private static final String password = "password";
    private static Connection connection;

    public static void main(String[] args) {
        establishConnection();
        executeSelectQuery();
        executeUpdateQuery();
        executeInsertQuery();
        executeDeleteQuery();
        closeConnection();
    }

    private static void establishConnection() {
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to database!");
        } catch (SQLException e) {
            System.out.println("Failed to connect to database");
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static void executeSelectQuery() {
        String query = "SELECT * FROM mytable";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                System.out.println(resultSet.getString("columnName"));
            }
        } catch (SQLException e) {
            System.out.println("Failed to execute select query");
            e.printStackTrace();
        }
    }

    private static void executeUpdateQuery() {
        String query = "UPDATE mytable SET columnName='newValue' WHERE columnName='oldValue'";
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Update query executed successfully");
        } catch (SQLException e) {
            System.out.println("Failed to execute update query");
            e.printStackTrace();
        }
    }

    private static void executeInsertQuery() {
        String query = "INSERT INTO mytable (columnName) VALUES ('newValue')";
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Insert query executed successfully");
        } catch (SQLException e) {
            System.out.println("Failed to execute insert query");
            e.printStackTrace();
        }
    }

    private static void executeDeleteQuery() {
        String query = "DELETE FROM mytable WHERE columnName='oldValue'";
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            System.out.println("Delete query executed successfully");
        } catch (SQLException e) {
            System.out.println("Failed to execute delete query");
            e.printStackTrace();
        }
    }

    private static void closeConnection() {
        try {
            connection.close();
            System.out.println("Connection closed!");
        } catch (SQLException e) {
            System.out.println("Failed to close connection");
            e.printStackTrace();
        }
    }
}