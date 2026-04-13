import java.sql.*;

public class java_38721_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String query = "INSERT INTO employees (name, email) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);

            // Setting parameters for insertion
            statement.setString(1, "John Doe");
            statement.setString(2, "john.doe@example.com");

            // Execute the query
            statement.executeUpdate();

            // Close connection
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}