import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_38349_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        // Step 1: Register JDBC driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Step 2: Establish a database connection
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/mydb", "username", "password");
             Statement statement = connection.createStatement()) {

            // Step 3: Execute a SQL query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM mytable");

            // Step 4: Process the result set
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                System.out.println("id = " + id + ", name = " + name);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}