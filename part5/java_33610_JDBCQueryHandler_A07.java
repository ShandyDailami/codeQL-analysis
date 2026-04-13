import java.sql.*;

public class java_33610_JDBCQueryHandler_A07 {
    public static boolean authenticate(String username, String password) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String driver = "com.mysql.cj.jdbc.Driver";
        String dbUsername = "myUsername";
        String dbPassword = "myPassword";

        try {
            Class.forName(driver);

            // Creating a connection
            Connection connection = DriverManager.getConnection(url, dbUsername, dbPassword);

            // Prepared statement
            String query = "SELECT password FROM users WHERE username = ?";
            PreparedStatement pstmt = connection.prepareStatement(query);
            pstmt.setString(1, username);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String dbPasswordFromDB = rs.getString("password");
                return BCrypt.checkpw(password, dbPasswordFromDB);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        boolean isAuthenticated = authenticate("user", "password");
        System.out.println("Is authenticated? " + isAuthenticated);
    }
}