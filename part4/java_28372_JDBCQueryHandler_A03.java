import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_28372_JDBCQueryHandler_A03 {

    // Database credentials
    private String url = "jdbc:mysql://localhost:3306/mydb";
    private String username = "root";
    private String password = "password";

    // JDBC driver name and database URL
    private static final String DRIVER = "com.mysql.jdbc.Driver";

    // Method to create a connection to the database
    public Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found " + e);
        } catch (SQLException e) {
            System.out.println("SQL exception occurred " + e);
        }
        return conn;
    }

    // Method to execute a query
    public void executeQuery(String query) {
        Connection conn = null;
        try {
            conn = getConnection();
            if (conn != null) {
                // write the query here
                // assume the query is a simple string concatenation
                String safeQuery = "SELECT * FROM users WHERE username = '" + query + "' AND password = '" + query + "'";
                // execute the query
                conn.createStatement().executeUpdate(safeQuery);
            }
        } catch (SQLException e) {
            System.out.println("An error occurred in executeQuery method " + e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Error in closing connection " + e);
                }
            }
        }
    }
}