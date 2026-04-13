import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class java_18797_JDBCQueryHandler_A03 {

    public static void main(String[] args) {
        // Load database driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Connect to database
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/testdb?useSSL=false", "username", "password")) {

            // Prepare statement
            try (Statement statement = connection.createStatement()) {

                // Execute SQL query
                String sql = "SELECT * FROM Employees";
                ResultSet resultSet = statement.executeQuery(sql);

                // Process result set
                while (resultSet.next()) {
                    String firstName = resultSet.getString("FirstName");
                    String lastName = resultSet.getString("LastName");
                    System.out.println(firstName + " " + lastName);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}