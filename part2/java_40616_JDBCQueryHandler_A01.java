import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_40616_JDBCQueryHandler_A01 {

    private static final String URL = "jdbc:your_database_url";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            // Step 1: Load the Driver
            Class.forName("com.mysql.jdbc.Driver");

            // Step 2: Open a Connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 3: Prepare a SQL statement
            statement = connection.prepareStatement("SELECT * FROM YOUR_TABLE");

            // Step 4: Execute the SQL statement
            resultSet = statement.executeQuery();

            // Step 5: Process the ResultSet
            while (resultSet.next()) {
                // Here you can process each row of the ResultSet
                String column1 = resultSet.getString("column1");
                // ... and so on
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            // Step 6: Close the Resources
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}