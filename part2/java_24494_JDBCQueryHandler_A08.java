import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_24494_JDBCQueryHandler_A08 {
    private Connection conn;
    private Statement stmt;

    // Initialize the connection
    public java_24494_JDBCQueryHandler_A08(String dbURL, String userName, String password) throws SQLException {
        conn = DriverManager.getConnection(dbURL, userName, password);
        stmt = conn.createStatement();
    }

    // Execute the query and return the ResultSet
    public ResultSet executeQuery(String query) throws SQLException {
        return stmt.executeQuery(query);
    }

    // Close the connection and statement
    public void close() throws SQLException {
        if (stmt != null) stmt.close();
        if (conn != null) conn.close();
    }

    public static void main(String[] args) {
        try {
            JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost/test", "username", "password");
            ResultSet rs = handler.executeQuery("SELECT * FROM Users");
            while (rs.next()) {
                System.out.println(rs.getString("name"));
            }
            handler.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}