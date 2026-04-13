import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_12980_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "password";

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Step 1: Register JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open Connection
            connection = DriverManager.getConnection(url, username, password);

            // Step 3: Create Statement
            statement = connection.createStatement();

            // Step 4: Execute Query
            resultSet = statement.executeQuery("SELECT * FROM mytable WHERE id = " + args[0]);

            // Step 5: Process Result
            while (resultSet.next()) {
                System.out.println("Found record: " + resultSet.getString("id") + ", " + resultSet.getString("name"));
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 6: Close ResultSet, Statement and Connection
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}