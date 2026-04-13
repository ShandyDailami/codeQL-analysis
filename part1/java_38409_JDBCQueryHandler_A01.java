import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_38409_JDBCQueryHandler_A01 {
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE id = ?")) {

            // Set parameter and get result set
            statement.setInt(1, 1);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                System.out.println("User id: " + resultSet.getInt("id"));
                System.out.println("User name: " + resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}