import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_19019_JDBCQueryHandler_A01 {

    // Define your SQL query here
    private static final String SQL_SELECT_ALL_FROM_EMPLOYEES = "SELECT * FROM employees";

    public static void main(String[] args) {
        // Load the driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Connect to your database
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/mydb?useSSL=false", "username", "password")) {

            // Create a new statement
            try (Statement statement = connection.createStatement()) {

                // Execute your query
                try (ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_FROM_EMPLOYEES)) {

                    // Process the result set
                    while (resultSet.next()) {
                        System.out.println("Employee ID: " + resultSet.getString("id"));
                        System.out.println("Employee Name: " + resultSet.getString("name"));
                        System.out.println("Employee Email: " + resultSet.getString("email"));
                    }

                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}