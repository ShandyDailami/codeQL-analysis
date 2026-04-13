import java.sql.*;

public class java_37466_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        String username = "placeholder"; // This is a placeholder
        String jdbcURL = "jdbc:mysql://localhost:3306/mydatabase";
        String usernameDB = "root";
        String passwordDB = "password";

        try {
            Connection con = DriverManager.getConnection(jdbcURL, usernameDB, passwordDB);
            System.out.println("Successfully connected to database");

            String SQLQuery = "SELECT * FROM users WHERE username = ?";
            PreparedStatement pstmt = con.prepareStatement(SQLQuery);
            pstmt.setString(1, username);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String user = rs.getString("username");
                String password = rs.getString("password");

                System.out.println("Username: " + user);
                System.out.println("Password: " + password);
            }

            con.close();

        } catch (SQLException ex) {
            System.out.println("Error in connection: " + ex.getMessage());
        }
    }
}