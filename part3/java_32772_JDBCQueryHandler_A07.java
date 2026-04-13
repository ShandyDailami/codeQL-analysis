import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_32772_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        // Step 1: Register MySQL JDBC driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

        // Step 2: Establish database connection
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "username";
        String password = "password";
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            // Step 3: Create a statement object
            try (Statement statement = connection.createStatement()) {
                // Step 4: Execute a SQL query
                ResultSet resultSet = statement.executeQuery("SELECT * FROM users");

                // Step 5: Process the result set
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