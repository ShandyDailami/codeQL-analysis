import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class java_22850_JDBCQueryHandler_A01 {

    public static void main(String[] args) {
        // Load JDBC driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found");
            return;
        }

        // Set up connection
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "password";
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("Error connecting to the database");
            return;
        }

        // Create and execute query
        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                String query = "SELECT * FROM my_table"; // replace with your query
                ResultSet resultSet = statement.executeQuery(query);

                while (resultSet.next()) {
                    System.out.println("Row 1: " + resultSet.getString("column1"));
                    System.out.println("Row 2: " + resultSet.getString("column2"));
                    // and so on...
                }

                resultSet.close();
                statement.close();
            } catch (SQLException e) {
                System.out.println("Error executing query");
            }

            connection.close();
        }
    }
}