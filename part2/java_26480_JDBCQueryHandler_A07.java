import java.sql.*;

public class java_26480_JDBCQueryHandler_A07 {
    // In this example, we are using static connection details, 
    // in a real-world application, these details should be retrieved from a configuration file
    private static final String USER = "username";
    private static final String PASS = "password";
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";

    public static void main(String[] args) {
        try {
            Connection connection = getConnection();
            if (connection != null) {
                performQuery(connection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Connection getConnection() throws SQLException {
        // Create a connection to the database
        Connection connection = DriverManager.getConnection(URL, USER, PASS);

        // Print a message if the connection was successful
        if (connection != null) {
            System.out.println("Connected to database successfully!");
        } else {
            System.out.println("Failed to connect to database!");
        }

        return connection;
    }

    private static void performQuery(Connection connection) throws SQLException {
        // Perform a query
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM myTable");

        // Print all the results
        while (resultSet.next()) {
            System.out.println("ID: " + resultSet.getInt("id"));
            System.out.println("Name: " + resultSet.getString("name"));
        }
    }
}