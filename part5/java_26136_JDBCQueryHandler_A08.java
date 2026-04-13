import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_26136_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "username";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // 1. Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Establish a connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // 3. Create a prepared statement
            String sql = "INSERT INTO users (username, password, email) VALUES (?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);

            // 4. Set parameters and execute the query
            preparedStatement.setString(1, "testUser");
            preparedStatement.setString(2, "testPassword");
            preparedStatement.setString(3, "testEmail@example.com");
            preparedStatement.executeUpdate();

            System.out.println("New user created successfully!");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // 5. Close the statement and connection
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}