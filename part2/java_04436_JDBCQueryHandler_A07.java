import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_04436_JDBCQueryHandler_A07 {
    private static final String URL = "jdbc:your_database_url";
    private static final String USER = "username";
    private static final String PASSWORD = "password";

    private Connection connection;

    public java_04436_JDBCQueryHandler_A07() {
        initializeConnection();
    }

    private void initializeConnection() {
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Error while connecting to the database: " + e.getMessage());
        }
    }

    public ResultSet executeQuery(String query) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            System.out.println("Error while executing the query: " + e.getMessage());
        }

        return resultSet;
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Error while closing the database connection: " + e.getMessage());
        }
    }
}