import java.sql.*;

public class java_18283_JDBCQueryHandler_A08 {

    private static final String URL = "jdbc:mysql://localhost:3306/dbname";
    private static final String USER = "username";
    private static final String PASS = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open a connection
            Connection con = DriverManager.getConnection(URL, USER, PASS);

            // Step 3: Perform SQL operations
            String query = "SELECT * FROM Users WHERE username = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, "alice"); // Alice's username

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String password = rs.getString("password");
                System.out.println("Password: " + password);
            }

            // Step 4: Close resources
            rs.close();
            pstmt.close();
            con.close();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}