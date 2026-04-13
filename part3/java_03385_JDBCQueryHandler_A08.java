import java.sql.*;

public class java_03385_JDBCQueryHandler_A08 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            String query = "SELECT * FROM Users WHERE Password = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, "newPassword");
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                String username = result.getString("Username");
                String newPassword = "newPassword";
                String updateQuery = "UPDATE Users SET Password = ? WHERE Username = ?";
                PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
                updateStatement.setString(1, newPassword);
                updateStatement.setString(2, username);
                updateStatement.executeUpdate();
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}