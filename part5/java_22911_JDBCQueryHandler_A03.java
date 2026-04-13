import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class java_22911_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        // Load the driver for the database
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL Java Connector failed to load the driver");
            return;
        }

        // Establish the connection
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "username";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to the database");

            // Create a statement
            try (Statement statement = connection.createStatement()) {
                // Execute a query
                String query = "SELECT * FROM mytable";
                try (ResultSet resultSet = statement.executeQuery(query)) {
                    while (resultSet.next()) {
                        System.out.println(resultSet.getString("column1") + ", " + resultSet.getString("column2"));
                    }
                }
            }

            // Close the statement
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error executing the query");
        }
    }
}