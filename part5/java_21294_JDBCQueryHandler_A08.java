import java.sql.*;

public class java_21294_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "username";
        String password = "password";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            String sql = "SELECT * FROM Users WHERE password='password'";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String user = resultSet.getString("user");
                String password = resultSet.getString("password");
                System.out.println("User: " + user);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}