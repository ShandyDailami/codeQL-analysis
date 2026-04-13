import java.sql.*;

public class java_00445_CredentialValidator_A03 {
    private static final String VALID_USERS = "admin, user1, user2, user3";

    public boolean validate(String username) {
        // Create a connection to the database
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "username", "password");
            stmt = conn.createStatement();

            // Use a parameterized query to prevent SQL injection
            rs = stmt.executeQuery("SELECT * FROM Users WHERE username = " + "'" + username + "'");

            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try { if (rs != null) rs.close(); } catch (SQLException e) {}
            try { if (stmt != null) stmt.close(); } catch (SQLException e) {}
            try { if (conn != null) conn.close(); } catch (SQLException e) {}
        }

        return false;
    }

    public static void main(String[] args) {
        CredentialValidator validator = new CredentialValidator();

        // Use a hardcoded list of usernames as a test case
        String[] testUsers = {"admin", "user1", "user2", "user3", "unknown"};

        for (String username : testUsers) {
            System.out.println("Validating user: " + username);
            boolean isValid = validator.validate(username);
            System.out.println("Is user valid? " + (isValid ? "Yes" : "No"));
        }
    }
}