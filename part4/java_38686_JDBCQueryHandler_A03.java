import java.sql.*;

public class java_38686_JDBCQueryHandler_A03 {

    private static final String url = "jdbc:mysql://localhost:3306/test";
    private static final String user = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        insertUser(new User("Alice", "alice@email.com", "password"));
        insertUser(new User("Bob", "bob@email.com", "password"));
    }

    private static void insertUser(User user) {
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String sql = "INSERT INTO users (username, email, password) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getPassword());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error in inserting user into database: " + e.getMessage());
        }
    }

    public static class User {
        private String username;
        private String email;
        private String password;

        public java_38686_JDBCQueryHandler_A03(String username, String email, String password) {
            this.username = username;
            this.email = email;
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public String getEmail() {
            return email;
        }

        public String getPassword() {
            return password;
        }
    }
}