import java.sql.*;

public class java_21860_JDBCQueryHandler_A08 {
    private static final String url = "jdbc:mysql://localhost:3306/testdb";
    private static final String username = "root";
    private static final String password = "password";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            String query = "SELECT * FROM Users WHERE email = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, "test@test.com"); // replace with the actual email

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                System.out.println("User found!");
            } else {
                System.out.println("User not found!");
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}