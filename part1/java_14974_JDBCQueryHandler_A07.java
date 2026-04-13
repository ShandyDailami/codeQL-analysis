import java.sql.*;

public class java_14974_JDBCQueryHandler_A07 {
    // Define a static database URL and username, password
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "myuser";
    private static final String PASSWORD = "mypassword";

    // Create a connection
    private Connection connection;

    // Constructor
    public java_14974_JDBCQueryHandler_A07() {
        try {
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
       
        }
    }

    // Method to execute a query and return a result set
    public ResultSet executeQuery(String query) {
        try {
            Statement statement = this.connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // Method to execute a query and do not return a result set
    public void executeUpdate(String query) {
        try {
            Statement statement = this.connection.createStatement();
            statement.executeUpdate(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to close the connection
    public void closeConnection() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}