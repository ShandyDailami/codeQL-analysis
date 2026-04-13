import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_42082_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        String url = "jdbc:oracle:thin:@localhost:1521:xe"; // replace with your database url
        String username = "username"; // replace with your username
        String password = "password"; // replace with your password

        try {
            // Step 1: Load the Oracle JDBC driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Step 2: Establish a connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 3: Execute a query
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM YOUR_TABLE"); // replace with your query

            // Step 4: Process the result set
            while (resultSet.next()) {
                // Here, replace with your code to process the result set
                String column1 = resultSet.getString("column1");
                String column2 = resultSet.getString("column2");
                // ...
            }

            // Step 5: Close the connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}