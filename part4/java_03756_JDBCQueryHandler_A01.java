import java.sql.*;

public class java_03756_JDBCQueryHandler_A01 {

    private static final String url = "jdbc:mysql://localhost:3306/testdb";
    private static final String username = "root";
    private static final String password = "password";

    private static Connection con = null;

    static {
        try {
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String query = "SELECT * FROM users WHERE username = ?";

        try {
            PreparedStatement pstmt = con.prepareStatement(query);

            // Setting the parameter value
            pstmt.setString(1, "testUser");

            // Execute the query
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println("Found user: " + rs.getString("username"));
            }

            rs.close();
            pstmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}