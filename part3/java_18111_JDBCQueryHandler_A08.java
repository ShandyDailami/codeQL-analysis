import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_18111_JDBCQueryHandler_A08 {

    public static void main(String[] args) {
        Connection connection = null;
        try {
            // Step 1: Load MySQL Connector/J driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Step 2: Establish a connection
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "username", "password");

            // Step 3: Perform a simple query
            String query = "SELECT * FROM myTable";
            java.sql.Statement statement = connection.createStatement();
            java.sql.ResultSet resultSet = statement.executeQuery(query);

            // Step 4: Process the results
            while (resultSet.next()) {
                String column1 = resultSet.getString("column1");
                String column2 = resultSet.getString("column2");
                // ... process the data
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 5: Close the connection
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