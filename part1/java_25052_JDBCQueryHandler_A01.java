import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_25052_JDBCQueryHandler_A01 {

    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private Connection connection;

    public java_25052_JDBCQueryHandler_A01() {
        try {
            // Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection
            this.connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error while connecting to the database: " + e.getMessage());
        }
    }

    public void closeConnection() {
        try {
            if (this.connection != null && !this.connection.isClosed()) {
                this.connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Error while closing connection: " + e.getMessage());
        }
    }

    public ResultSet executeQuery(String query) {
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = this.connection.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            System.out.println("Error while executing query: " + e.getMessage());
        }
        return resultSet;
    }

    public static void main(String[] args) {
        JDBCQueryHandler jdbcQueryHandler = new JDBCQueryHandler();

        // Example of accessing data
        ResultSet resultSet = jdbcQueryHandler.executeQuery("SELECT * FROM users");
        while (resultSet.next()) {
            System.out.println("User ID: " + resultSet.getInt("id"));
            System.out.println("User Name: " + resultSet.getString("name"));
        }

        jdbcQueryHandler.closeConnection();
    }
}