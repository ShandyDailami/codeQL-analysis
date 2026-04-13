import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_39401_JDBCQueryHandler_A08 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "myusername";
        String password = "mypassword";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            // Perform security-sensitive operations here
            // For example, executing a SELECT query
            String query = "SELECT * FROM Users";
            ResultSet result = connection.createStatement().executeQuery(query);

            while (result.next()) {
                String username = result.getString("username");
                String password = result.getString("password");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}