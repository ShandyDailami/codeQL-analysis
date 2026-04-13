import java.sql.*;

public class java_37676_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();

            // Example of a SELECT query
            String sql = "SELECT * FROM Users WHERE Name='John' AND Password='password'";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String name = rs.getString("Name");
                String password = rs.getString("Password");
                System.out.println("Name: " + name + ", Password: " + password);
            }

            // Example of a DELETE query
            sql = "DELETE FROM Users WHERE Name='John' AND Password='password'";
            stmt.executeUpdate(sql);

            conn.close();
        } catch (SQLException e) {
            System.out.println("Error in JDBC connection: " + e.getMessage());
       
        }
    }
}