import java.sql.*;

public class java_19352_JDBCQueryHandler_A03 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Users WHERE username = '" + args[0] + "'")) {

            if (rs.next()) {
                String password = rs.getString("password");
                if (password.equals(args[1])) {
                    System.out.println("Access granted");
                } else {
                    System.out.println("Access denied");
                }
            } else {
                System.out.println("User not found");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}