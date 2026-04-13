import java.sql.*;

public class java_13955_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "myusername";
        String password = "mypassword";

        try {
            // Step 1: Establish a Connection
            Connection conn = DriverManager.getConnection(url, username, password);

            // Step 2: Prepare a Statement
            Statement stmt = conn.createStatement();

            // Step 3: Execute a Query
            String sql = "SELECT * FROM Users";
            ResultSet rs = stmt.executeQuery(sql);

            // Step 4: Process the ResultSet
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                System.out.println("Username: " + username);
            }

            // Step 5: Close the Connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}