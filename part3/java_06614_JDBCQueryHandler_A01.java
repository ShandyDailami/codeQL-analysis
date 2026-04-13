import java.sql.*;

public class java_06614_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "myuser";
        String password = "mypassword";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement()) {

            // BrokenAccessControl: Access to database is restricted
            ResultSet rs = stmt.executeQuery("SELECT * FROM myTable");

            while (rs.next()) {
                String column1 = rs.getString("column1");
                // Do something with column1
            }

        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}