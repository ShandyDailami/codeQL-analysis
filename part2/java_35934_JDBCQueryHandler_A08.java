import java.sql.*;

public class java_35934_JDBCQueryHandler_A08 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "password";

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement();

            // Example of a query that could be dangerous
            // This query could open a database cursor
            ResultSet rs = stmt.executeQuery("SELECT * FROM Users WHERE Name = 'John'");

            while (rs.next()) {
                String name = rs.getString("Name");
                String email = rs.getString("Email");
                System.out.println("Name: " + name);
                System.out.println("Email: " + email);
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}