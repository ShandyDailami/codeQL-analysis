import java.sql.*;

public class java_26554_JDBCQueryHandler_A03 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // Step 1: Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish the connection
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            // Step 3: Prepare the statement
            String query = "SELECT * FROM users WHERE id = ?";
            pstmt = conn.prepareStatement(query);

            // Step 4: Set the parameter
            pstmt.setInt(1, 101); // Assuming id is an integer

            // Step 5: Execute the statement
            ResultSet rs = pstmt.executeQuery();

            // Step 6: Process the result
            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                System.out.println("Name: " + name + ", Age: " + age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 7: Close the statement and connection
            if (pstmt != null) {
                try { pstmt.close(); } catch (SQLException e) {}
            }
            if (conn != null) {
                try { conn.close(); } catch (SQLException e) {}
            }
        }
    }
}