import java.sql.*;

public class java_38988_JDBCQueryHandler_A01 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private Connection conn;

    public java_38988_JDBCQueryHandler_A01() {
        try {
            this.conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(query);
            return pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void executeUpdate(String query) {
        try {
            PreparedStatement pstmt = this.conn.prepareStatement(query);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();

        String selectQuery = "SELECT * FROM Users";
        ResultSet rs = handler.executeQuery(selectQuery);

        while (rs.next()) {
            System.out.println(rs.getString("username"));
        }

        String updateQuery = "UPDATE Users SET password = 'new_password' WHERE username = 'admin'";
        handler.executeUpdate(updateQuery);

        rs = handler.executeQuery(selectQuery);
        while (rs.next()) {
            System.out.println(rs.getString("username"));
        }
    }
}