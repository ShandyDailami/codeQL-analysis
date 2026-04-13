import java.sql.*;

public class java_04986_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "myusername";
        String password = "mypassword";

        try {
            // Step 1: Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open a connection
            Connection conn = DriverManager.getConnection(url, username, password);

            // Step 3: Create a statement
            Statement stmt = conn.createStatement();

            // Step 4: Execute a SQL statement
            String sql = "SELECT * FROM mytable WHERE mycolumn = ?";
            PreparedStatement pstmt = stmt.prepareStatement(sql);
            pstmt.setInt(1, 42); // Bound value for the placeholder in the SQL statement

            ResultSet rs = pstmt.executeQuery();

            // Step 5: Process the result set
            while (rs.next()) {
                System.out.println("Found: " + rs.getString("mycolumn"));
            }

            // Step 6: Close the connection
            rs.close();
            pstmt.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
        }
    }
}