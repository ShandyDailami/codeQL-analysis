import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_16484_JDBCQueryHandler_A07 {

    // The URL, username, and password are considered secure.
    private static final String url = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String username = "username";
    private static final String password = "password";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            // Here is where you would perform your security-sensitive operation, such as a query.
            performQuery(connection);
        } catch (SQLException e) {
            System.err.println("Error connecting to the database");
            e.printStackTrace();
        }
    }

    private static void performQuery(Connection connection) throws SQLException {
        String query = "SELECT * FROM users WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        // Here, we are setting the parameter value to a safe default value, this could be from another source.
        preparedStatement.setInt(1, 123);

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            // Here, we are fetching data from the result set.
            String user = resultSet.getString("username");
            // Here, we are handling the fetched data.
            System.out.println("User: " + user);
        }
    }
}