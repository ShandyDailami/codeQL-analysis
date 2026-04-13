import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_01216_JDBCQueryHandler_A03 {

    public static void main(String[] args) {
        // Step 1: Register JDBC Driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // replace with your JDBC driver
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Step 2: Establish a Connection
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/testdb", "username", "password")) {

            // Step 3: Execute a Query
            String query = "SELECT * FROM employees"; // replace with your query
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(query);

                // Step 4: Process the ResultSet
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