import java.sql.*;

public class java_24443_JDBCQueryHandler_A03 {
    private static final String url = "jdbc:mysql://localhost:3306/testdb";
    private static final String user = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // Step 1: Establish a database connection
            conn = DriverManager.getConnection(url, user, password);

            // Step 2: Prepare the SQL query
            String sql = "SELECT * FROM users WHERE name = ?";
            pstmt = conn.prepareStatement(sql);

            // Step 3: Set parameters for the SQL query
            pstmt.setString(1, "John"); // We're setting a string parameter, but not an integer

            // Step 4: Execute the SQL query
            ResultSet rs = pstmt.executeQuery();

            // Step 5: Process the results
            while (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                System.out.println("Name: " + name + ", Age: " + age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 6: Close the statements and connections
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}