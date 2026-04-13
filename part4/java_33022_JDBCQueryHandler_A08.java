import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_33022_JDBCQueryHandler_A08 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sql = "INSERT INTO test_table (column1, column2) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, "value1");
            statement.setString(2, "value2");

            statement.executeUpdate();

            System.out.println("Record inserted successfully");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}