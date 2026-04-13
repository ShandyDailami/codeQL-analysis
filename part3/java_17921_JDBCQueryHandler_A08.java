import java.sql.*;

public class java_17921_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String query = "SELECT * FROM users WHERE name = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, "John"); // This is a real example, you should replace it with the actual user name

            ResultSet result = statement.executeQuery();

            if (result.next()) {
                System.out.println("User found: " + result.getString("name"));
            } else {
                System.out.println("User not found");
            }

            connection.close();
        } catch (SQLException e) {
            System.out.println("Error connecting to the database: " + e.getMessage());
        }
    }
}