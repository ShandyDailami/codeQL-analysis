import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_36295_JDBCQueryHandler_A07 {

    public static void main(String[] args) {
        // URL connection
        String url = "jdbc:mysql://localhost:3306/mydb";
        // Username and password for database
        String username = "user";
        String password = "password";

        try {
            // Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Prepare and execute a query
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "testUser");
            statement.setString(2, "testPassword");

            ResultSet result = statement.executeQuery();

            while (result.next()) {
                System.out.println("User found!");
            }

            // Close connection
            result.close();
            statement.close();
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}