import java.sql.*;

public class java_19721_JDBCQueryHandler_A01 {
    private static Connection conn = null;
    private static Statement stmt = null;

    static {
        try {
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mydb", "username", "password");
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        getUserData("user1");
    }

    private static void getUserData(String userName) {
        String sql = "SELECT password FROM Users WHERE username = ?";

        try {
            ResultSet rs = stmt.executeQuery(sql, userName);
            if (rs.next()) {
                String password = rs.getString("password");
                System.out.println("Password: " + password);
            } else {
                System.out.println("No user found!");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}