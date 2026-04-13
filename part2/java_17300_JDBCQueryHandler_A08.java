import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_17300_JDBCQueryHandler_A08 {
    // Step 1: Define a URL, username, and password.
    private static final String URL = "jdbc:mysql://localhost:3306/db_name";
    private static final String USER = "username";
    private static final String PASSWORD = "password";

    // Step 2: Create a method to connect to the database.
    public Connection connect() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    // Step 3: Create a method to execute a query.
    public void executeQuery(String query) {
        Connection connection = connect();
        try {
            if (connection != null) {
                PreparedStatement statement = connection.prepareStatement(query);
                statement.executeUpdate();

                ResultSet resultSet = statement.getResultSet();
                while (resultSet.next()) {
                    // Step 4: Print out the result set.
                    System.out.println("Result set: " + resultSet.getString("column_name"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}