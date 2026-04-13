import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_05671_JDBCQueryHandler_A08 {
    private Connection connection;
    private Statement statement;

    public java_05671_JDBCQueryHandler_A08() {
        // Establish the connection to the database
        String url = "jdbc:your_database_url";
        String username = "your_username";
        String password = "your_password";

        try {
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        // Execute the query and return the result
        ResultSet result = null;
        try {
            result = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void closeConnection() {
        // Close the connection
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        ResultSet result = handler.executeQuery("SELECT * FROM your_table");
        // Handle the result
        handler.closeConnection();
    }
}