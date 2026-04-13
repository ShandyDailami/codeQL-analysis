import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_01467_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        // Step 1: Load the driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Step 2: Establish the connection
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/mydatabase",
                "username",
                "password")) {

            // Step 3: Create a statement
            try (Statement statement = connection.createStatement()) {

                // Step 4: Execute a SQL query
                ResultSet resultSet = statement.executeQuery("SELECT * FROM mytable");

                // Step 5: Process the result
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    System.out.println("ID: " + id + ", Name: " + name);
                }
            }

            // Step 6: Close the connection
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}