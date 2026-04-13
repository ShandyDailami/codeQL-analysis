import java.sql.*;

public class java_23693_JDBCQueryHandler_A07 {

    private Connection conn;
    private Statement stmt;

    public java_23693_JDBCQueryHandler_A07(String url, String user, String password) throws SQLException {
        conn = DriverManager.getConnection(url, user, password);
        stmt = conn.createStatement();
    }

    public ResultSet executeQuery(String query) throws SQLException {
        return stmt.executeQuery(query);
    }

    public void closeConnection() throws SQLException {
        if (stmt != null) stmt.close();
        if (conn != null) conn.close();
    }

    public static void main(String[] args) {
        // Insert your connection details here.
        try {
            new VanillaJDBCQueryHandler("jdbc:mysql://localhost/test", "username", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}