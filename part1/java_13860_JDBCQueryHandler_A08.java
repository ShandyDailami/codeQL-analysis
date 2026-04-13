import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_13860_JDBCQueryHandler_A08 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/database";
        String username = "username";
        String password = "password";
        String driver = "com.mysql.cj.jdbc.Driver";

        try {
            // Step 1: Load MySQL JDBC Driver
            Class.forName(driver);

            // Step 2: Establish a Connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 3: Execute a SQL Query
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM security_table");

            // Step 4: Process the ResultSet
            while (resultSet.next()) {
                String column1 = resultSet.getString("column1");
                // Process column1...
            }

            // Step 5: Close the Connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}