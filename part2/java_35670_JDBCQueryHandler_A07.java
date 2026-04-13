import java.sql.*;
import java.util.Properties;

public class java_35670_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            // Step 1: Set up the database connection
            Properties properties = new Properties();
            properties.setProperty("user", "username");
            properties.setProperty("password", "password");
            properties.setProperty("url", "jdbc:mysql://localhost:3306/mydatabase");
            properties.setProperty("driver", "com.mysql.jdbc.Driver");
            
            connection = DriverManager.getConnection(
                    properties.getProperty("url"),
                    properties.getProperty("user"),
                    properties.getProperty("password"));

            // Step 2: Create the SQL statement
            statement = connection.createStatement();

            // Step 3: Execute the SQL statement
            ResultSet resultSet = statement.executeQuery("SELECT * FROM mytable");

            // Step 4: Process the result set
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                System.out.println("Name: " + name + ", Age: " + age);
            }

            // Step 5: Close the resources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 6: Always close the resources
            try {
                if (statement != null)
                    statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}