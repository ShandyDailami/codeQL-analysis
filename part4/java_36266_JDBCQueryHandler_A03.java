import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class java_36266_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        // Step 1: Establish a Connection to the Database
        String url = "jdbc:mysql://localhost:3306/mydb"; // replace with your database URL
        String username = "myuser"; // replace with your username
        String password = "mypassword"; // replace with your password

        Connection connection = null;
        Statement statement = null;

        try {
            // Step 2: Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 3: Open a connection
            connection = DriverManager.getConnection(url, username, password);

            // Step 4: Execute a query
            statement = connection.createStatement();
            String sql = "SELECT * FROM my_table"; // replace with your SQL query
            ResultSet resultSet = statement.executeQuery(sql);

            // Step 5: Process the ResultSet
            while (resultSet.next()) {
                System.out.println("Record " + resultSet.getInt("id") + ": " + resultSet.getString("name"));
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 6: Close the Statement and Connection
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}