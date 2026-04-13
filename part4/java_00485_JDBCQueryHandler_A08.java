import java.sql.*;

public class java_00485_JDBCQueryHandler_A08 {
    private static final String url = "jdbc:mysql://localhost:3306/testDB";
    private static final String user = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            String query = "SELECT * FROM UserData WHERE userID = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);

            // Setting the parameter value
            pstmt.setString(1, "user1");

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String id = rs.getString("userID");
                String pw = rs.getString("userPW");

                System.out.println("User ID: " + id);
                System.out.println("User Password: " + pw);
            }

            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error in accessing the database");
            e.printStackTrace();
        }
    }
}