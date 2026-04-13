import java.sql.*;

public class java_30925_SessionManager_A07 {
    private static Connection conn;
    private static Statement stmt;

    public static void main(String[] args) {
        openConnection();
        manageUsers();
        closeConnection();
    }

    private static void openConnection() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost/testdb", "username", "password");
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void manageUsers() {
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM Users");
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                // Here you can add more security measures. For example, you can hash the password before storing it.
                // You can also use session management (like HttpSession) to store the user's ID and validate it in every request.
                System.out.println("Username: " + username + ", Password: " + password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void closeConnection() {
        try {
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}