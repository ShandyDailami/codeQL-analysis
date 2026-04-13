import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class java_20190_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/db_name";
        String username = "username";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {

            // Start with a clean table
            statement.executeUpdate("DROP TABLE IF EXISTS test_table");
            statement.executeUpdate("CREATE TABLE test_table (id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(255))");

            // Insert some data
            statement.executeUpdate("INSERT INTO test_table (name) VALUES ('John')");
            statement.executeUpdate("INSERT INTO test_table (name) VALUES ('Jane')");

            // Select all data
            ResultSet resultSet = statement.executeQuery("SELECT * FROM test_table");
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id") + ", Name: " + resultSet.getString("name"));
            }

            // Update data
            statement.executeUpdate("UPDATE test_table SET name = 'Jane Smith' WHERE id = 2");

            // Select updated data
            resultSet = statement.executeQuery("SELECT * FROM test_table");
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id") + ", Name: " + resultSet.getString("name"));
            }

            // Delete data
            statement.executeUpdate("DELETE FROM test_table WHERE id = 2");

            // Select all data after deletion
            resultSet = statement.executeQuery("SELECT * FROM test_table");
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id") + ", Name: " + resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}