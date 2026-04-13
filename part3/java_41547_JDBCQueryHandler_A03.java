import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class java_41547_JDBCQueryHandler_A03 {

    // A03_Injection: This is a security sensitive operation
    private String dbUrl;
    private String username;
    private String password;

    // Constructor for JDBCQueryHandler
    public java_41547_JDBCQueryHandler_A03(String dbUrl, String username, String password) {
        this.dbUrl = dbUrl;
        this.username = username;
        this.password = password;
    }

    // Method to execute SQL queries
    public ResultSet executeQuery(String query) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // A03_Injection: Use a driver to connect to the database
            Class.forName("com.mysql.cj.jdbc.Driver");

            // A03_Injection: Create a connection to the database
            connection = DriverManager.getConnection(dbUrl, username, password);

            // A03_Injection: Create a statement for the query
            statement = connection.createStatement();

            // A03_Injection: Execute the query
            resultSet = statement.executeQuery(query);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // A03_Injection: Close the resources
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // Return the result set
        return resultSet;
    }
}