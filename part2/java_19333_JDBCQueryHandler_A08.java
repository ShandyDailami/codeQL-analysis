import java.sql.*;

public class java_19333_JDBCQueryHandler_A08 {

    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();

            String query = "SELECT * FROM Users WHERE id = " + getUserIdFromInput();
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                handleResultSet(resultSet);
            } else {
                System.out.println("User not found!");
            }

            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error occurred while trying to execute query: " + e.getMessage());
        }
    }

    private static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Error occurred while trying to get connection: " + e.getMessage());
            return null;
        }
    }

    private static void handleResultSet(ResultSet resultSet) {
        try {
            // Handle the result set here
            // For instance, we are just printing the user's name
            System.out.println("User name: " + resultSet.getString("name"));
        } catch (SQLException e) {
            System.out.println("Error occurred while trying to handle result set: " + e.getMessage());
        }
    }

    private static int getUserIdFromInput() {
        // Prompt user for input and return it
        return 1; // For simplicity, we're just returning 1
    }
}