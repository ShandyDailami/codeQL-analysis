import java.sql.*;

public class java_35329_JDBCQueryHandler_A07 {
    // Database credentials
    private static final String DB_USERNAME = "user";
    private static final String DB_PASSWORD = "password";

    // Database connection
    private Connection connection = null;

    // PreparedStatement for executing queries
    private PreparedStatement preparedStatement = null;

    // ResultSet for storing the query results
    private ResultSet resultSet = null;

    // Method to connect to the database
    public boolean connectToDB() {
        try {
            // Load the database driver
            Class.forName("com.mysql.jdbc.Driver");

            // Establish the database connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", DB_USERNAME, DB_PASSWORD);

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    // Method to execute a query
    public boolean executeQuery(String query) {
        try {
            // Prepare the query
            preparedStatement = connection.prepareStatement(query);

            // Execute the query
            resultSet = preparedStatement.executeQuery();

            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    // Method to get the result
    public ResultSet getResult() {
        return resultSet;
    }

    // Method to close the connection
    public void closeConnection() {
        try {
            if (resultSet != null)
                resultSet.close();

            if (preparedStatement != null)
                preparedStatement.close();

            if (connection != null)
                connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}