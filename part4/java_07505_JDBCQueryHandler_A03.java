import java.sql.*;

public class java_07505_JDBCQueryHandler_A03 {

    // Define our database credentials
    private static final String USER = "username";
    private static final String PASSWORD = "password";
    private static final String URL = "jdbc:mysql://localhost:3306/db_name";

    public static void main(String[] args) {
        executeQuery();
    }

    public static void executeQuery() {
        try {
            // Step 1: Register the driver
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

            // Step 2: Establish a connection
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 3: Define a query
            String query = "SELECT * FROM users";

            // Step 4: Prepare and execute our query
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            // Step 5: Process the result set
            while (resultSet.next()) {
                System.out.println(resultSet.getString("username"));
            }

            // Step 6: Cleanup
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}