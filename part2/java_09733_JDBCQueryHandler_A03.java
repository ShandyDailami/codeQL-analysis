import java.sql.*;

public class java_09733_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        // This is a very simple connection string.
        // Normally, you'd use environment variables or a secure configuration file.
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        try {
            // Step 1: Load the Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Create a Connection
            Connection con = DriverManager.getConnection(url, username, password);

            // Step 3: Create a Statement
            Statement stmt = con.createStatement();

            // Step 4: Execute a Query
            ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE email = '" + args[0] + "'");

            // Step 5: Handle the ResultSet
            while (rs.next()) {
                System.out.println("User found: " + rs.getString("email"));
            }

            // Step 6: Close the Connection
            con.close();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}