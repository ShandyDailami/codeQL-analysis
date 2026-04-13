import java.sql.*;

public class java_25737_JDBCQueryHandler_A08 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            String query = "SELECT * FROM Users WHERE Email = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, "invalid@email.com"); // Invalid email

            ResultSet result = statement.executeQuery();

            if (result.next()) {
                System.out.println("Invalid email found in the database");
            } else {
                System.out.println("Invalid email not found in the database");
            }

            result.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}