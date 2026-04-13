import java.sql.*;

public class java_33651_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/db_name";
        String username = "username";
        String password = "password";

        try {
            // Step 1: Establish the connection
            Connection conn = DriverManager.getConnection(url, username, password);

            // Step 2: Prepare the statement
            Statement stmt = conn.createStatement();

            // Step 3: Execute the query
            ResultSet rs = stmt.executeQuery("SELECT * FROM users WHERE role='admin'");

            // Step 4: Process the results
            while (rs.next()) {
                String name = rs.getString("name");
                String role = rs.getString("role");
                System.out.println("Name: " + name + ", Role: " + role);
            }

            // Step 5: Close the connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}