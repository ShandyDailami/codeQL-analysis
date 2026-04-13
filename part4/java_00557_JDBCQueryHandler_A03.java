import java.sql.*;

public class java_00557_JDBCQueryHandler_A03 {
    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    // Instantiate a connection
    private Connection conn = null;
    private Statement stmt = null;
    private PreparedStatement pstmt = null;

    // Constructor
    public java_00557_JDBCQueryHandler_A03() {
        connectToDatabase();
    }

    // Connect to the database
    private void connectToDatabase() {
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method for inserting a user into the database
    public void insertUser(String name, String email) {
        try {
            String sql = "INSERT INTO USERS (NAME, EMAIL) VALUES (?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method for retrieving a user from the database
    public ResultSet getUser(String email) {
        try {
            String sql = "SELECT * FROM USERS WHERE EMAIL = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Method for updating a user in the database
    public void updateUser(String email, String name) {
        try {
            String sql = "UPDATE USERS SET NAME = ? WHERE EMAIL = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method for deleting a user from the database
    public void deleteUser(String email) {
        try {
            String sql = "DELETE FROM USERS WHERE EMAIL = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}