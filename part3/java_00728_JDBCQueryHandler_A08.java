import java.sql.*;

public class java_00728_JDBCQueryHandler_A08 {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Establish a connection
            Connection conn = DriverManager.getConnection(JDBC_URL, USER, PASS);

            // Step 2: Prepare a statement
            String SQL = "SELECT * FROM Users WHERE email = ?";
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, "test@test.com"); // test@test.com is an example email

            // Step 3: Execute the query
            ResultSet rs = pstmt.executeQuery();

            // Step 4: Process the result
            while (rs.next()) {
                String email = rs.getString("email");
                String password = rs.getString("password");
                System.out.println("Email: " + email);
                System.out.println("Password: " + password);
            }

            // Step 5: Close the connection
            rs.close();
            pstmt.close();
            conn.close();

        } catch (SQLException se) {
            se.printStackTrace();
        }
    }
}