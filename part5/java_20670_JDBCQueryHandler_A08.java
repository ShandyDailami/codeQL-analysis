import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_20670_JDBCQueryHandler_A08 {
    private Connection connection;
    private Statement statement;

    // This method will be used to establish a connection to the database
    public void openConnection(String url, String username, String password) throws SQLException {
        connection = DriverManager.getConnection(url, username, password);
        statement = connection.createStatement();
    }

    // This method will be used to execute a SELECT query
    public ResultSet executeQuery(String query) throws SQLException {
        return statement.executeQuery(query);
    }

    // This method will be used to execute a INSERT, UPDATE or DELETE query
    public void executeUpdate(String query) throws SQLException {
        statement.executeUpdate(query);
    }

    // This method will be used to close the connection
    public void closeConnection() throws SQLException {
        statement.close();
        connection.close();
    }

    // This method will be used to handle any potential SQLException
    public void handleException(SQLException e) {
        // TODO: handle SQLException, this is a placeholder and should be replaced by your actual code
        System.out.println("An error has occurred: " + e.getMessage());
    }
}