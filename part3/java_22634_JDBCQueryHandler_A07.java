import java.sql.*;

public class java_22634_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "myuser";
        String password = "mypassword";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT * FROM users WHERE username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "exampleuser");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String usernameDB = resultSet.getString("username");
                String passwordDB = resultSet.getString("password");
                System.out.println("Username: " + usernameDB);
                System.out.println("Password: " + passwordDB);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}