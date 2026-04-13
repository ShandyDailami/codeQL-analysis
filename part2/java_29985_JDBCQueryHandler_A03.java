import java.sql.*;

public class java_29985_JDBCQueryHandler_A03 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // Step 1: Load the Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish the Connection
            conn = DriverManager.getConnection(URL, USER, PASS);

            // Step 3: Prepare the SQL Statement
            String sql = "SELECT * FROM users WHERE id = ?";
            pstmt = conn.prepareStatement(sql);

            // Step 4: Set Parameters
            pstmt.setInt(1, 100); // Assuming user's ID is 100

            // Step 5: Execute the Query
            ResultSet rs = pstmt.executeQuery();

            // Step 6: Process the Result Set
            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Step 7: Cleanup
            if (pstmt != null) {
                try { pstmt.close(); } catch(SQLException e) {}
            }
            if (conn != null) {
                try { conn.close(); } catch(SQLException e) {}
            }
        }
    }
}