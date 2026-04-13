import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class java_17887_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        // Step 1: Load the MySQL driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC driver not found. Exiting application.");
            e.printStackTrace();
        }

        // Step 2: Establish a connection to the MySQL database
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("Connection failed. Exiting application.");
            e.printStackTrace();
            return;
        }

        // Step 3: Execute a query
        if (connection != null) {
            try {
                String sql = "SELECT * FROM employees";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);

                // Step 4: Process the results
                while (resultSet.next()) {
                    System.out.println(resultSet.getString("name"));
                }
            } catch (SQLException e) {
                System.out.println("Error executing query. Exiting application.");
                e.printStackTrace();
            }
        }

        // Step 5: Close the connection
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Error closing connection. Exiting application.");
                e.printStackTrace();
            }
        }
    }
}