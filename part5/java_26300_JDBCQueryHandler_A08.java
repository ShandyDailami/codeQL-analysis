import java.sql.*;
import java.util.Properties;

public class java_26300_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            // Step 1: Establish a connection to the database
            Properties props = new Properties();
            props.setProperty("user", "root"); // replace with your username
            props.setProperty("password", "password"); // replace with your password
            props.setProperty("useSSL", "false");
            props.setProperty("serverSelection", "creative");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", props);

            // Step 2: Create a statement
            statement = connection.createStatement();

            // Step 3: Execute a query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM mytable WHERE condition"); // replace with your condition

            // Step 4: Process the result set
            while (resultSet.next()) {
                String column1 = resultSet.getString("column1"); // replace with your column names
                int column2 = resultSet.getInt("column2"); // replace with your column names
                // ... do something with the result set
            }

            // Step 5: Close the connection
            connection.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}