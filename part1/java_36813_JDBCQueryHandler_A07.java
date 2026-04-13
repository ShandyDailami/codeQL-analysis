import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class java_36813_JDBCQueryHandler_A07 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        try {
            // Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create a connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Create a SQL statement
            String query = "CREATE TABLE Users (" +
                    "ID INT PRIMARY KEY," +
                    "Username VARCHAR(50)," +
                    "Password VARCHAR(50))";

            // Prepare the SQL statement
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            // Execute the SQL statement
            preparedStatement.execute();

            // Close the connection
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}