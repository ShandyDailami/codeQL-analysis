import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_14180_SessionManager_A01 {

    // JDBC driver name and database URL
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/testdb";
    // Username and password
    private static final String username = "root";
    private static final String password = "root";

    // Main method
    public static void main(String[] args) {
        Connection connection = null;
        try {
            // Step 1: Register JDBC driver
            Class.forName(driver);

            // Step 2: Establish a connection
            connection = DriverManager.getConnection(url, username, password);

            // Step 3: Execute SQL statement
            String SQL = "SELECT * FROM Users";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL);

            // Step 4: Handle the result set
            while (resultSet.next()) {
                System.out.println("User: " + resultSet.getString("username"));
            }
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}