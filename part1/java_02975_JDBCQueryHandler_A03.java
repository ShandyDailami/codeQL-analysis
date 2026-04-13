import java.sql.*;

public class java_02975_JDBCQueryHandler_A03 {

    private Connection conn;

    public java_02975_JDBCQueryHandler_A03(String dbURL, String userName, String password) {
        try {
            this.conn = DriverManager.getConnection(dbURL, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void execute(String query, Object... parameters) {
        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            for (int i = 0; i < parameters.length; i++) {
                pstmt.setObject(i + 1, parameters[i]);
            }
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query, Object... parameters) {
        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            for (int i = 0; i < parameters.length; i++) {
                pstmt.setObject(i + 1, parameters[i]);
            }
            return pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/mydb", "myuser", "mypassword");
        handler.execute("SELECT * FROM users WHERE username = ? AND password = ?", "user1", "pass1");
        ResultSet rs = handler.executeQuery("SELECT * FROM users WHERE username = ? AND password = ?", "user2", "pass2");
        while (rs.next()) {
            System.out.println(rs.getString("username"));
        }
    }
}