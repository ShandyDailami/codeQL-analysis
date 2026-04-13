import java.sql.*;

public class java_32309_JDBCQueryHandler_A03 {

    // Injectable parameters for JDBC connection
    private String url;
    private String username;
    private String password;

    // Constructor
    public java_32309_JDBCQueryHandler_A03(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    // Method to perform a SQL query
    public ResultSet executeQuery(String query) throws SQLException {
        Connection conn = DriverManager.getConnection(url, username, password);
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(query);
    }

    // Method to perform a SQL update
    public int executeUpdate(String query) throws SQLException {
        Connection conn = DriverManager.getConnection(url, username, password);
        Statement stmt = conn.createStatement();
        return stmt.executeUpdate(query);
    }

    // Method to close the connection
    public void closeConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(url, username, password);
        conn.close();
    }
}