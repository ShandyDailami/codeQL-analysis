import java.sql.*;

public class java_08614_JDBCQueryHandler_A07 {
    private Connection conn;

    public java_08614_JDBCQueryHandler_A07() {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "username";
        String password = "password";

        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rs;
    }

    public void executeUpdate(String query) {
        Statement stmt = null;

        try {
            stmt = conn.createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();

        String query = "SELECT * FROM users WHERE username = ?";
        PreparedStatement pstmt = handler.conn.prepareStatement(query);
        pstmt.setString(1, "user1");

        ResultSet rs = handler.executeQuery(query);

        while (rs.next()) {
            System.out.println(rs.getString("password"));
        }
    }
}