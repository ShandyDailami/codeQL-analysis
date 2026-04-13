import java.sql.*;
import java.util.Properties;

public class java_31715_JDBCQueryHandler_A08 {
    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    public static void main(String[] args) {
        try {
            // Step 1: Set up the database connection
            Properties props = new Properties();
            props.setProperty("user", "username");
            props.setProperty("password", "password");
            props.setProperty("database", "database_name");
            props.setProperty("url", "jdbc:mysql://localhost:3306/mydb");
            connection = DriverManager.getConnection(props.getProperty("url"), props);

            // Step 2: Create the SQL statement
            String query = "SELECT * FROM my_table WHERE my_condition";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);

            // Step 3: Handle the result set
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                // Process the data...
            }

            // Step 4: Cleanup
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}