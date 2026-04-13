import java.sql.*;

public class java_12048_JDBCQueryHandler_A03 {

    // This is the connection object that will be used to execute queries.
    private Connection conn;

    // The username and password for the database connection.
    private String username;
    private String password;

    // The JDBC driver name and database URL.
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/test";

    // Construct a JDBCQueryHandler with a given username and password.
    public java_12048_JDBCQueryHandler_A03(String username, String password) {
        this.username = username;
        this.password = password;
        initializeConnection();
    }

    // Initialize the connection.
    private void initializeConnection() {
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, username, password);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Execute a query and return the result.
    public ResultSet executeQuery(String query) {
        try {
            Statement stmt = conn.createStatement();
            return stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Close the connection.
    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}