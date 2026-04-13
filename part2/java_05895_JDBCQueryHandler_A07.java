import java.sql.*;

public class java_05895_JDBCQueryHandler_A07 {

    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void main(String[] args) {
        try {
            Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM Users WHERE Username = 'test'";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String username = rs.getString("Username");
                String password = rs.getString("Password");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}