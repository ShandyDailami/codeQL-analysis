import java.sql.*;

public class java_26566_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "password";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            String sql = "SELECT * FROM Users WHERE username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "testUser");

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String user = resultSet.getString("username");
                String password = resultSet.getString("password");

                System.out.println("User found: " + user);
            } else {
                System.out.println("User not found");
            }

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}