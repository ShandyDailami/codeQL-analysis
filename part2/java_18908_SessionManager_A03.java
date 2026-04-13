import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class java_18908_SessionManager_A03 {

    // Load the driver
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Connect to the database
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "username", "password");
    }

    // Perform database operations
    public void performOperations() throws SQLException {
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = getConnection();
            stmt = conn.createStatement();

            // Insert a new user
            String insertUser = "INSERT INTO users (username, password) VALUES ('user1', 'password1')";
            stmt.executeUpdate(insertUser);

            // Retrieve the user
            String selectUser = "SELECT * FROM users WHERE username='user1'";
            ResultSet rs = stmt.executeQuery(selectUser);
            if (rs.next()) {
                System.out.println("User retrieved from database: " + rs.getString("username"));
            }
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    public static void main(String[] args) throws SQLException {
        SessionManager manager = new SessionManager();
        manager.performOperations();
    }
}