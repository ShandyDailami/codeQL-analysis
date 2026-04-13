import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_32697_JDBCQueryHandler_A08 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sql = "INSERT INTO test_table (column1, column2) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            // Set the parameters for the SQL statement
            statement.setString(1, "Value1");
            statement.setInt(2, 12345);

            // Execute the SQL statement
            statement.executeUpdate();

        } catch (SQLException e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}