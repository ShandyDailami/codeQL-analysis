import java.sql.*;

public class java_29757_JDBCQueryHandler_A08 {

    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public void executeQuery(String query) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                // Perform security-sensitive operations related to A08_IntegrityFailure
                String column1 = resultSet.getString("column1");
                String column2 = resultSet.getString("column2");

                // Use column1 and column2 for further processing
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }
}