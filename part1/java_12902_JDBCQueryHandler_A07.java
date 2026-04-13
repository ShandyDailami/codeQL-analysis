import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class java_12902_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        // Step 1: Load the database driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found");
            e.printStackTrace();
        }

        // Step 2: Establish a connection
        String url = "jdbc:mysql://localhost:3306/db_name";
        String username = "username";
        String password = "password";

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("Connection failed");
            e.printStackTrace();
        }

        // Step 3: Execute a SQL query
        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                String sql = "SELECT * FROM table_name";
                ResultSet resultSet = statement.executeQuery(sql);

                // Step 4: Handle the result set
                while (resultSet.next()) {
                    // process each row
                }
            } catch (SQLException e) {
                System.out.println("Failed to execute query");
                e.printStackTrace();
            }
        }

        // Step 5: Close the connection
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Failed to close connection");
                e.printStackTrace();
            }
        }
    }
}