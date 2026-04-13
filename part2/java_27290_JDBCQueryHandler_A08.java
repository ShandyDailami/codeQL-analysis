import java.sql.*;

public class java_27290_JDBCQueryHandler_A08 {

    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "user1";
    private static final String PASSWORD = "password1";

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

            // Sample query to select user password
            String query = "SELECT password FROM Users WHERE username = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "user1");
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String dbPassword = rs.getString("password");
                if (PASSWORD.equals(dbPassword)) {
                    System.out.println("Password is correct");
                } else {
                    System.out.println("Password is incorrect");
                    // Here you might want to handle the integrity failure in a different way, e.g. by logging the error or retrying the operation
                }
            } else {
                System.out.println("User does not exist");
            }

            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }
    }
}