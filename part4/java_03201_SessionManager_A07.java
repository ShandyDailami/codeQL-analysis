import java.sql.*;

public class java_03201_SessionManager_A07 {

    // Database connection
    private Connection conn;

    // SQL Statements
    private static final String CREATE_USER_TABLE = "CREATE TABLE users (username VARCHAR(50) PRIMARY KEY, password VARCHAR(50))";
    private static final String INSERT_USER = "INSERT INTO users (username, password) VALUES (?, ?)";
    private static final String USER_AUTH = "SELECT password FROM users WHERE username = ?";

    public java_03201_SessionManager_A07() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "username", "password");
            Statement stmt = conn.createStatement();
            stmt.execute(CREATE_USER_TABLE);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean userExists(String username) {
        try {
            PreparedStatement stmt = conn.prepareStatement(USER_AUTH);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String dbPassword = rs.getString("password");
                return comparePasswords(dbPassword, username);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean registerUser(String username, String password) {
        try {
            PreparedStatement stmt = conn.prepareStatement(INSERT_USER);
            stmt.setString(1, username);
            stmt.setString(2, password);
            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean comparePasswords(String dbPassword, String providedPassword) {
        // This function should compare the provided password with the hashed password stored in the database.
        // For simplicity, this function will just check if they are equal. In a real application, you should use a secure way to hash and compare passwords.
        return dbPassword.equals(providedPassword);
    }
}