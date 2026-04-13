import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_18807_JDBCQueryHandler_A03 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "root";

        try {
            // Step 1: Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 3: Create a new table
            String createTableSql = "CREATE TABLE students (id INT PRIMARY KEY, name VARCHAR(50), age INT)";
            connection.createStatement().execute(createTableSql);

            // Step 4: Insert data into the table
            String insertDataSql = "INSERT INTO students (id, name, age) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(insertDataSql);
            statement.setInt(1, 1);
            statement.setString(2, "John Doe");
            statement.setInt(3, 20);
            statement.executeUpdate();

            statement.setInt(1, 2);
            statement.setString(2, "Jane Smith");
            statement.setInt(3, 22);
            statement.executeUpdate();

            // Step 5: Close the connection
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}