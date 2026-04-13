import java.sql.*;

public class java_05736_JDBCQueryHandler_A07 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        try (Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = con.createStatement()) {

            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement preparedStmt = con.prepareStatement(sql);

            // set parameters and get the result set
            preparedStmt.setString(1, "user1");
            preparedStmt.setString(2, "password1");
            ResultSet rs = preparedStmt.executeQuery();

            if (rs.next()) {
                System.out.println("User found!");
            } else {
                System.out.println("User not found!");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}