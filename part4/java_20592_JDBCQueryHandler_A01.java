import java.sql.*;

public class java_20592_JDBCQueryHandler_A01 {
    public static String getPassword(String username) {
        String password = null;
        try {
            // Load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish a connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "user", "password");

            // Prepare the statement
            PreparedStatement pstmt = con.prepareStatement("SELECT password FROM users WHERE username = ?");
            pstmt.setString(1, username);

            // Execute the query
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                password = rs.getString("password");
            }

            // Close the connection
            con.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return password;
    }

    public static void main(String[] args) {
        String password = getPassword("testuser");
        if (password != null) {
            System.out.println("Password: " + password);
        } else {
            System.out.println("User not found.");
        }
    }
}