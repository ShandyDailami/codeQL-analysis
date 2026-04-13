import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_20843_JDBCQueryHandler_A01 {

    private Connection conn;
    private Statement stmt;

    public java_20843_JDBCQueryHandler_A01(String url, String username, String password) throws SQLException {
        conn = DriverManager.getConnection(url, username, password);
        stmt = conn.createStatement();
    }

    public ResultSet executeQuery(String query) throws SQLException {
        return stmt.executeQuery(query);
    }

    public void close() throws SQLException {
        if (stmt != null) stmt.close();
        if (conn != null) conn.close();
    }

    public static void main(String[] args) {
        try {
            JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:your_db_url", "username", "password");
            ResultSet rs = handler.executeQuery("SELECT * FROM your_table");
            while (rs.next()) {
                System.out.println(rs.getString("column_name"));
            }
            handler.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}