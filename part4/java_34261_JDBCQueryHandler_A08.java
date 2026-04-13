import java.sql.*;

public class java_34261_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "myuser";
    private static final String PASSWORD = "mypassword";

    public static void main(String[] args) {
        executeQuery();
    }

    public static void executeQuery() {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {

            String query = "SELECT * FROM my_table WHERE column1 = :param1 AND column2 = :param2";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            // Set the parameters and execute the query
            preparedStatement.setInt(1, 10);
            preparedStatement.setString(2, "some_string");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                // process the result set
            }
        } catch (SQLException e) {
            // handle the exception
        }
    }
}