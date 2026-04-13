import java.sql.*;

public class java_08979_JDBCQueryHandler_A07 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "username";
    private static final String PASS = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection
            Connection conn = DriverManager.getConnection(URL, USER, PASS);

            // Step 3: Create a statement object
            Statement stmt = conn.createStatement();

            // Step 4: Execute a query
            String sql = "SELECT * FROM users WHERE id = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, 123);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }

            // Step 5: Close the connection
            rs.close();
            pstmt.close();
            stmt.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}