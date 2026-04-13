import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class java_00638_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        // Load MySQL driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Connect to MySQL server
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost/test?useSSL=false", "username", "password")) {

            // Prepare SQL query
            String sql = "SELECT * FROM users WHERE username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "admin"); // Here we inject 'admin'

            // Execute SQL query
            preparedStatement.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}