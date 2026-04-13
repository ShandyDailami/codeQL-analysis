import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_06552_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        // Provide the database credentials
        String username = "<username>";
        String password = "<password>";
        String url = "<url>";
        String databaseName = "<database_name>";

        // Establish a connection
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(url + databaseName, username, password);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM YOUR_SECURE_TABLE");

            // Process the result set
            while (resultSet.next()) {
                String column1 = resultSet.getString("COLUMN1");
                String column2 = resultSet.getString("COLUMN2");
                // ... and so on
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the resources
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