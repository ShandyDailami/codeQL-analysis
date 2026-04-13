import java.sql.*;

public class java_38316_JDBCQueryHandler_A03 {
    // Define the database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    // Create a connection
    private Connection connection;

    // Create a statement
    private Statement statement;

    // Constructor
    public java_38316_JDBCQueryHandler_A03() {
        try {
            // Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create a new connection
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // Create a new statement
            statement = connection.createStatement();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Method to execute a simple query
    public void executeQuery(String query) {
        try {
            // Execute the query
            ResultSet resultSet = statement.executeQuery(query);

            // Print the result
            while (resultSet.next()) {
                System.out.println("Query result: " + resultSet.getString("column_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to close the connection and statement
    public void close() {
        try {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler jdbcQueryHandler = new JDBCQueryHandler();
        jdbcQueryHandler.executeQuery("SELECT * FROM my_table");
        jdbcQueryHandler.close();
    }
}