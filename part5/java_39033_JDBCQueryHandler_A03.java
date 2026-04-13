import java.sql.*;

public class java_39033_JDBCQueryHandler_A03 {
    public static boolean authenticate(String username, String password) {
        // JDBC Driver name and database URL
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/testdb";
        String user = "root";
        String pass = "password";

        try {
            // Load MySQL JDBC Driver
            Class.forName(driver);

            // Create a connection to the database
            Connection con = DriverManager.getConnection(url, user, pass);

            // Create a statement using a connection
            Statement stmt = con.createStatement();

            // Execute a query
            String sql = "SELECT * FROM users WHERE username = '" + username + "'";
            ResultSet rs = stmt.executeQuery(sql);

            // Extract data from result set
            while (rs.next()) {
                String dbPass = rs.getString("password");

                // Compare passwords
                if (pass.equals(dbPass)) {
                    System.out.println("Authenticated successfully!");
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        authenticate("username", "password");
    }
}