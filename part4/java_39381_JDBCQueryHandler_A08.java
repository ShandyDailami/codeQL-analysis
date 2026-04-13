import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_39381_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        // Load driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        // Connect to database
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to database");

            // Prepare statement
            try (Statement statement = connection.createStatement()) {
                String sql = "SELECT * FROM employees";
                ResultSet resultSet = statement.executeQuery(sql);

                // Process result
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    System.out.println("ID: " + id + ", Name: " + name);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}