import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_36246_JDBCQueryHandler_A03 {

    // This is a placeholder for the username, password and URL
    // Replace these with your actual credentials
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";

    private Connection connection;

    public java_36246_JDBCQueryHandler_A03() {
        try {
            // Step 1: Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeQuery(String query) {
        try {
            // Step 3: Create a statement object
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            // Step 4: Execute the query
            ResultSet resultSet = preparedStatement.executeQuery();

            // Step 5: Handle the result
            while (resultSet.next()) {
                // Replace with actual logic to handle result set
                System.out.println(resultSet.getString("column_name"));
            }

            // Close all statements, cursors and connections
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler jdbcQueryHandler = new JDBCQueryHandler();
        jdbcQueryHandler.executeQuery("SELECT * FROM my_table");
    }
}