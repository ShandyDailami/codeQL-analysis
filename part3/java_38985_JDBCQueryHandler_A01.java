import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_38985_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "testuser";
        String password = "testpassword";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to database");

            String selectQuery = "SELECT * FROM users";
            ResultSet rs = conn.createStatement().executeQuery(selectQuery);

            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                System.out.println("Name: " + name);
                System.out.println("Email: " + email);
            }

        } catch (SQLException e) {
            System.out.println("Error connecting to database");
            e.printStackTrace();
        }
    }
}