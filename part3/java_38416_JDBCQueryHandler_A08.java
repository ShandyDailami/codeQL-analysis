import java.sql.*;

public class java_38416_JDBCQueryHandler_A08 {
    // JDBC driver name and database URL
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";

    // Database credentials
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        // Step 1: Register JDBC driver
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Step 2: Open a connection to the database
        try (Connection con = DriverManager.getConnection(DB_URL, USER, PASS)) {
            System.out.println("Connected to database successfully!");

            // Step 3: Prepare a statement
            String SQL = "UPDATE users SET password = ? WHERE username = ?";
            PreparedStatement pstmt = con.prepareStatement(SQL);

            // Step 4: Set parameters
            pstmt.setString(1, "new_password"); // new password
            pstmt.setString(2, "testuser"); // username

            // Step 5: Execute update SQL statement
            pstmt.executeUpdate();

            System.out.println("Password updated successfully!");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}