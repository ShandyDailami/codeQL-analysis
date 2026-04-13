import java.sql.*;

public class java_30090_JDBCQueryHandler_A03 {
    // Database credentials
    private static final String DB_USERNAME = "username";
    private static final String DB_PASSWORD = "password";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";

    // Main method to run the JDBCQueryHandler
    public static void main(String[] args) {
        JDBCQueryHandler jdbcQueryHandler = new JDBCQueryHandler();
        jdbcQueryHandler.run();
    }

    // Method to run the JDBCQueryHandler
    public void run() {
        // Establish a connection
        Connection connection = establishConnection();

        // If the connection was established successfully, proceed
        if (connection != null) {
            // Perform a query
            performQuery(connection);

            // Close the connection
            closeConnection(connection);
        } else {
            // If the connection was not established, print an error message
            System.out.println("Failed to connect to the database");
        }
    }

    // Method to establish a connection to the database
    private Connection establishConnection() {
        try {
            return DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (SQLException e) {
            System.out.println("Error while connecting to the database: " + e.getMessage());
            return null;
        }
    }

    // Method to close the connection to the database
    private void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error while closing the connection: " + e.getMessage());
            }
        }
    }

    // Method to perform a query
    private void performQuery(Connection connection) {
        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                String sql = "SELECT * FROM mytable"; // replace with your SQL query
                ResultSet resultSet = statement.executeQuery(sql);

                while (resultSet.next()) {
                    // process the result set here
                    System.out.println(resultSet.getString("columnName")); // replace "columnName" with the name of the column you want to process
                }

                resultSet.close();
                statement.close();
            } catch (SQLException e) {
                System.out.println("Error while performing the query: " + e.getMessage());
            }
        }
    }
}