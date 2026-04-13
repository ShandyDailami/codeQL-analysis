import java.sql.*;

public class java_33842_JDBCQueryHandler_A01 {

    // private static variables for connection establishment
    private static String dbURL = "jdbc:mysql://localhost:3306/myDatabase";
    private static String username = "root";
    private static String password = "password";

    // private static variable for connection object
    private Connection connection;

    // private static variable for statement object
    private Statement statement;

    // Constructor
    public java_33842_JDBCQueryHandler_A01() {
        establishConnection();
    }

    // Method to establish connection with database
    private void establishConnection() {
        try {
            // load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // establish connection
            connection = DriverManager.getConnection(dbURL, username, password);

            // setup statement
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to execute SQL query
    public ResultSet executeQuery(String query) {
        try {
            return statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Method to execute non-query (e.g. update, delete)
    public int executeUpdate(String query) {
        try {
            return statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    // Main method
    public static void main(String[] args) {
        // Create instance of JDBCQueryHandler
        JDBCQueryHandler jdbcQueryHandler = new JDBCQueryHandler();

        // Execute a query
        String query = "SELECT * FROM myTable";
        ResultSet resultSet = jdbcQueryHandler.executeQuery(query);

        // Process the result set
        while (resultSet.next()) {
            System.out.println(resultSet.getString("myField"));
        }

        // Execute a non-query (e.g. update)
        String updateQuery = "UPDATE myTable SET myField = 'NewValue' WHERE myField = 'OldValue'";
        jdbcQueryHandler.executeUpdate(updateQuery);
    }
}