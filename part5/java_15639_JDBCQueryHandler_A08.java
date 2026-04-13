import java.sql.*;

public class java_15639_JDBCQueryHandler_A08 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        // Step 1: Establish a connection
        try (Connection con = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            System.out.println("Connected to the database");

            // Step 2: Prepare a statement
            String sql = "INSERT INTO Users (username, password) VALUES (?, ?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, "testUser");
            pstmt.setString(2, "testPassword");

            // Step 3: Execute the statement
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("A new user was inserted successfully");
            }

            // Step 4: Retrieve the user
            pstmt = con.prepareStatement("SELECT * FROM Users WHERE username = ?");
            pstmt.setString(1, "testUser");
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String user = rs.getString("username");
                String password = rs.getString("password");
                System.out.println("User: " + user + ", Password: " + password);
            } else {
                System.out.println("No user found with the given username");
            }

        } catch (SQLException e) {
            System.out.println("Error in connection or execution: " + e.getMessage());
        }
    }
}