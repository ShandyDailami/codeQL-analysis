import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_00773_JDBCQueryHandler_A07 {
    private Connection conn;
    private Statement stmt;

    // Constructor
    public java_00773_JDBCQueryHandler_A07(String url, String username, String password) throws SQLException {
        conn = DriverManager.getConnection(url, username, password);
        stmt = conn.createStatement();
    }

    public ResultSet executeQuery(String query) throws SQLException {
        return stmt.executeQuery(query);
    }

    public int executeUpdate(String query) throws SQLException {
        return stmt.executeUpdate(query);
    }

    public void close() throws SQLException {
        if (stmt != null) stmt.close();
        if (conn != null) conn.close();
    }

    public static void main(String[] args) {
        try {
            JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/mydb", "username", "password");
            ResultSet rs = handler.executeQuery("SELECT * FROM users WHERE id = " + args[0]);
            while (rs.next()) {
                System.out.println(rs.getString("username"));
            }
            handler.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}