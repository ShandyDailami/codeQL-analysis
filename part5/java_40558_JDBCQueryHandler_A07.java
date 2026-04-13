import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_40558_JDBCQueryHandler_A07 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase"; // replace with your database details
        String username = "root"; // replace with your username
        String password = "password"; // replace with your password

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM Users WHERE username = ? AND password = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                pstmt.setString(1, "username1"); // replace with your username
                pstmt.setString(2, "password1"); // replace with your password
                ResultSet rs = pstmt.executeQuery();

                if (rs.next()) {
                    System.out.println("User found!");
                } else {
                    System.out.println("User not found!");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error in query execution: " + e.getMessage());
            e.printStackTrace();
        }
    }
}