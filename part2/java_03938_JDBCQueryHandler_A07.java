import java.sql.*;
import java.util.Properties;

public class java_03938_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        Properties props = new Properties();
        props.setProperty("user","username");
        props.setProperty("password","password");

        try (Connection connection = DriverManager.getConnection(url, props)) {
            String query = "INSERT INTO Users (username, password) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, "testuser");
            statement.setString(2, "testpassword");

            statement.executeUpdate();

            System.out.println("Data inserted successfully!");
        } catch (SQLException e) {
            System.out.println("Failed to connect to database: " + e.getMessage());
        }
    }
}