import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class java_16566_JDBCQueryHandler_A01 {

    // List of allowed users
    private static List<String> allowedUsers = new ArrayList<>();

    static {
        allowedUsers.add("user1");
        allowedUsers.add("user2");
    }

    public static void main(String[] args) {
        // Create connection
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/testdb", "username", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Query handler
        String query = "SELECT * FROM Users WHERE username = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, "user1");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String username = rs.getString("username");
                if (isAllowed(username)) {
                    System.out.println("User " + username + " is allowed.");
                } else {
                    System.out.println("User " + username + " is NOT allowed.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static boolean isAllowed(String username) {
        return allowedUsers.contains(username);
    }
}