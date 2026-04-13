import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_26368_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        // Step 1: Load the driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // assuming MySQL JDBC driver
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Step 2: Establish the connection
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/testdb", "username", "password")) {

            // Step 3: Execute the query
            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery("SELECT * FROM tableName");) {

                    // Step 4: Process the results
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String name = resultSet.getString("name");
                        System.out.println("id: " + id + ", name: " + name);
                    }
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Step 5: Close the connection
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}