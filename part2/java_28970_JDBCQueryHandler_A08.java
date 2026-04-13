import java.sql.*;

public class java_28970_JDBCQueryHandler_A08 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "password";

        try {
            // Step 1: Establish a connection
            Connection conn = DriverManager.getConnection(url, username, password);

            // Step 2: Prepare a statement
            Statement stmt = conn.createStatement();

            // Step 3: Execute a query
            ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE email = 'test@test.com'");

            // Step 4: Process the ResultSet
            while (rs.next()) {
                String email = rs.getString("email");
                String password = rs.getString("password");
                // perform integrity check here, for example, checking if the password matches the hash
                // if not, set a flag or log an error
            }

            // Step 5: Close the connection
            conn.close();

        } catch (SQLException e) {
            System.out.println("Error in JDBC code: " + e.getMessage());
        }
    }
}