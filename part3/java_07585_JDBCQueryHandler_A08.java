import java.sql.*;

public class java_07585_JDBCQueryHandler_A08 {

    public static void main(String[] args) {

        String sql = "SELECT username, password FROM Users WHERE username = ?";
        String username = "testuser";

        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/testdb?useSSL=false", "username", "password");

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String dbUsername = resultSet.getString("username");
                String dbPassword = resultSet.getString("password");
                System.out.println("Username: " + dbUsername);
                System.out.println("Password: " + dbPassword);
            }

            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}