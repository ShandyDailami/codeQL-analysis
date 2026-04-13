import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_18304_JDBCQueryHandler_A03 {

    public static void main(String[] args) {
        try {
            // Step 1: Load the MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish the Connection
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/testdb", "username", "password");

            // Step 3: Create the Statement
            Statement statement = connection.createStatement();

            // Step 4: Execute the SQL Query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employees");

            // Step 5: Process the Result
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                System.out.println("Name: " + name + ", Age: " + age);
            }

            // Step 6: Close the Connection
            resultSet.close();
            statement.close();
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}