import java.sql.*;

public class java_26599_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        // Establish connection with database
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "username";
        String password = "password";
        Connection conn = null;
        Statement stmt = null;

        try {
            conn = DriverManager.getConnection(url, username, password);
            stmt = conn.createStatement();

            // Execute SELECT statement
            String sql = "SELECT * FROM my_table";
            ResultSet rs = stmt.executeQuery(sql);

            // Process results
            while (rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");

                // Use the data
                System.out.println("ID: " + id + ", Name: " + name);
            }

            // Close connections
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}