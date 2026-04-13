import java.sql.*;

public class java_06375_JDBCQueryHandler_A07 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "myuser";
    private static final String PASS = "mypassword";

    public static void main(String[] args) {
        try {
            // Step 1: Register MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection
            Connection conn = DriverManager.getConnection(URL, USER, PASS);

            // Step 3: Prepare a statement
            String sql = "SELECT * FROM mytable WHERE username = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            // Step 4: Set parameters
            pstmt.setString(1, "user1");

            // Step 5: Execute the statement
            ResultSet rs = pstmt.executeQuery();

            // Step 6: Process the result
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.println("Username: " + username + ", Password: " + password);
            }

            // Step 7: Close the connection
            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}