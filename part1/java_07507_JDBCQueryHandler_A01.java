import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_07507_JDBCQueryHandler_A01 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url, username, password);

            // Example of a security-sensitive operation: accessing data
            String selectQuery = "SELECT * FROM Users";
            ResultSet result = conn.createStatement().executeQuery(selectQuery);

            while (result.next()) {
                String name = result.getString("name");
                String email = result.getString("email");
                System.out.println("Name: " + name);
                System.out.println("Email: " + email);
            }

            result.close();

            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}