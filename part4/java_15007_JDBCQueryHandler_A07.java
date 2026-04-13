import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_15007_JDBCQueryHandler_A07 {
    private static final String url = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String username = "username";
    private static final String password = "password";

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // Step 1: Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection
            connection = DriverManager.getConnection(url, username, password);

            // Step 3: Prepare a SQL statement
            String query = "SELECT * FROM my_table";
            preparedStatement = connection.prepareStatement(query);

            // Step 4: Execute the SQL statement
            ResultSet resultSet = preparedStatement.executeQuery();

            // Step 5: Process the result set
            while (resultSet.next()) {
                String column1 = resultSet.getString("column1");
                int column2 = resultSet.getInt("column2");
                // Process the data...
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 6: Close the connections
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
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