import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_27366_JDBCQueryHandler_A01 {
    private Connection conn;
    private PreparedStatement pstmt;

    public java_27366_JDBCQueryHandler_A01(String url, String user, String password) throws SQLException {
        this.conn = DriverManager.getConnection(url, user, password);
    }

    public ResultSet executeQuery(String query) throws SQLException {
        this.pstmt = conn.prepareStatement(query);
        return this.pstmt.executeQuery();
    }

    public void closeConnection() throws SQLException {
        if (this.pstmt != null) {
            this.pstmt.close();
        }

        if (this.conn != null) {
            this.conn.close();
        }
    }

    public static void main(String[] args) throws SQLException {
        JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost/test", "user", "password");
        ResultSet rs = handler.executeQuery("SELECT * FROM users");

        while (rs.next()) {
            System.out.println(rs.getString("username"));
        }

        handler.closeConnection();
    }
}