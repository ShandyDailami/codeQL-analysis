import java.sql.*;

public class java_11860_JDBCQueryHandler_A01 {
    // You can use any database here. For this example, I'll use MySQL.
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Get a connection to the database
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // Step 2: Prepare the SQL query
            String sql = "SELECT * FROM users WHERE username = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "admin"); // admin is the username

            // Step 3: Execute the query
            ResultSet rs = pstmt.executeQuery();

            // Step 4: Process the ResultSet
            while (rs.next()) {
                System.out.println(rs.getString("password"));
            }

            // Step 5: Close the connection
            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error while connecting to the database");
            e.printStackTrace();
        }
    }
}