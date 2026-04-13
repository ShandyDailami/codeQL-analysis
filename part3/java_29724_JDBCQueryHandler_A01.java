import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_29724_JDBCQueryHandler_A01 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connect to MySQL database
            Connection connection = DriverManager.getConnection(url, username, password);

            // Prepare SQL query
            String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // Hash password using SHA-256
            String passwordToHash = "password";
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] bytes = messageDigest.digest(passwordToHash.getBytes());
            String hashedPassword = new String(bytes);

            // Execute SQL query
            preparedStatement.setString(1, "user1");
            preparedStatement.setString(2, hashedPassword);
            preparedStatement.executeUpdate();

            // Close connection
            connection.close();

        } catch (ClassNotFoundException | SQLException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}