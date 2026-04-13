import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class java_01011_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "myuser";
        String password = "mypassword";

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            try (Statement stmt = conn.createStatement()) {
                String sql = "SELECT * FROM Users";
                ResultSet rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    String name = rs.getString("name");
                    String email = rs.getString("email");
                    System.out.println(name + ", " + email);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error in connection or SQL execution: " + e.getMessage());
        }
    }
}