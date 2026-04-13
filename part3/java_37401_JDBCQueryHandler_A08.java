import java.sql.*;

public class java_37401_JDBCQueryHandler_A08 {

    private static final String url = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String username = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            String sql = "SELECT * FROM users WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "testuser");
            ResultSet result = statement.executeQuery();

            if (result.next()) {
                System.out.println("User exists in the database.");
            } else {
                System.out.println("User does not exist in the database.");
            }

            connection.close();

        } catch (SQLException e) {
            System.out.println("Error while connecting to the database: " + e.getMessage());
        }
    }
}