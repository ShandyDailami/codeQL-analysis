import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_41297_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        // Step 1: Register JDBC driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Step 2: Establish a connection
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "myusername";
        String password = "mypassword";
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to the database");

            // Step 3: Execute a query
            String query = "SELECT * FROM mytable";
            try (java.sql.Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(query);

                // Step 4: Process the result set
                while (resultSet.next()) {
                    System.out.println(resultSet.getString("mycolumn"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}