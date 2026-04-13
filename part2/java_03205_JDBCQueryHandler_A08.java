import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_03205_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        // Load the driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Connect to the database
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/mydb", "username", "password")) {

            // Create a statement
            try (Statement statement = connection.createStatement()) {

                // Execute the query
                ResultSet resultSet = statement.executeQuery("SELECT * FROM my_table");

                // Process the results
                while (resultSet.next()) {
                    System.out.println(resultSet.getString("column_name"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}