import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_39119_JDBCQueryHandler_A03 {
    private Connection conn;

    public java_39119_JDBCQueryHandler_A03(String dbURL, String userName, String password) throws SQLException {
        conn = DriverManager.getConnection(dbURL, userName, password);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        Statement stmt = conn.createStatement();
        return stmt.executeQuery(query);
    }

    public void close() throws SQLException {
        conn.close();
    }

    public static void main(String[] args) {
        try {
            JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/mydatabase", "username", "password");

            ResultSet rs = handler.executeQuery("SELECT * FROM mytable");

            while (rs.next()) {
                System.out.println(rs.getString("mycolumn"));
            }

            handler.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}