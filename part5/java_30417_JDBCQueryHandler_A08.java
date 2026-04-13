import java.sql.*;

public class java_30417_JDBCQueryHandler_A08 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();

            // Starts with a SELECT query to get a row from a table
            String query = "SELECT * FROM Users WHERE username = 'testuser'";
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
           
                // Here, we are checking the integrity of the password. 
                // Normally, you would hash and compare the passwords, but for simplicity, 
                // we will just check if the password is not null.
                if (password == null) {
                    System.out.println("IntegrityFailure: Password is null!");
                }
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}