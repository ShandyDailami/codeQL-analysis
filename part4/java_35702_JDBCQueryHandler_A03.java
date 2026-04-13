import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_35702_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        // Step 1: Register the JDBC driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Step 2: Open a connection
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/mydb", "username", "password")) {

            // Step 3: Create a statement
            try (Statement statement = connection.createStatement()) {

                // Step 4: Execute a query
                ResultSet resultSet = statement.executeQuery("SELECT * FROM users");

                // Step 5: Process the result
                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    int age = resultSet.getInt("age");
                    System.out.println("Name: " + name + ", Age: " + age);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}