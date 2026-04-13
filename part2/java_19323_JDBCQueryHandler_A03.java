import java.sql.*;

public class java_19323_JDBCQueryHandler_A03 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "myuser";
        String password = "mypassword";

        try {
            Connection conn = DriverManager.getConnection(url, username, password);

            String query = "SELECT * FROM Users WHERE username = ?";
            PreparedStatement pstmt = conn.prepareStatement(query);

            // This is where we introduce the injection vulnerability
            // We will be injecting the SQL statement into the query string
            String injectedQuery = "SELECT * FROM Users WHERE username = 'baduser'";

            pstmt.setString(1, injectedQuery);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.println("Username: " + username);
            }

            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}