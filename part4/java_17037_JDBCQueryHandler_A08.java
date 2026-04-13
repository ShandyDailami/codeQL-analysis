import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class java_17037_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";

        try {
            // Step 1: Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Create a connection to the database
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 3: Prepare the SQL query
            String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            // Step 4: Execute the SQL query
            statement.setString(1, "newUser");
            statement.setString(2, "password");
            statement.executeUpdate();

            // Step 5: Close the connection
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}