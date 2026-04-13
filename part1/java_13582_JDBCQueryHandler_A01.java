import java.sql.*;

public class java_13582_JDBCQueryHandler_A01 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "username";
        String password = "password";

        try {
            // Step 1: Establish a connection to the database
            Connection conn = DriverManager.getConnection(url, username, password);

            // Step 2: Execute a query
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM mytable";
            ResultSet rs = stmt.executeQuery(sql);

            // Step 3: Process the results
            while (rs.next()) {
                // Assuming we have columns named "id" and "name"
                int id = rs.getInt("id");
                String name = rs.getString("name");

                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
            }

            // Step 4: Close the connection
            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Error in connection or query: " + e.getMessage());
        }
    }
}