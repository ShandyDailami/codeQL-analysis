import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_04324_JDBCQueryHandler_A01 {

    private Connection connection;

    // Constructor
    public java_04324_JDBCQueryHandler_A01(String url, String username, String password) throws SQLException {
        connection = DriverManager.getConnection(url, username, password);
    }

    // Method to execute a SQL query
    public ResultSet executeQuery(String query) throws SQLException {
        Statement statement = connection.createStatement();
        return statement.executeQuery(query);
    }

    // Method to close the connection
    public void closeConnection() throws SQLException {
        connection.close();
    }
}