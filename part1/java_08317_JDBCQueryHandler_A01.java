import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_08317_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sql = "INSERT INTO employees (name, salary) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, "John Doe");
            statement.setDouble(2, 70000.00);

            statement.executeUpdate();

            sql = "SELECT * FROM employees WHERE name = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, "John Doe");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                System.out.println("John Doe's salary is: " + resultSet.getDouble("salary"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}