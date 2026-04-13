import java.sql.*;

public class java_38288_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        String url = "your_database_url";
        String username = "your_username";
        String password = "your_password";

        try {
            // Step 1: Establish a connection
            Connection conn = DriverManager.getConnection(url, username, password);

            // Step 2: Run a query
            String sql = "SELECT * FROM your_table"; // replace with your actual table name
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // Step 3: Process the results
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                String email = rs.getString("email");

                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Email: " + email);
            }

            // Step 4: Close the connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}