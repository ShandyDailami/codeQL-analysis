import java.sql.*;

public class java_17663_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "myuser";
        String password = "mypassword";

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            String sql = "SELECT * FROM Users WHERE AuthFailure = true";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");

                System.out.println("Name: " + name);
                System.out.println("Email: " + email);
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error connecting to database");
        }
    }
}