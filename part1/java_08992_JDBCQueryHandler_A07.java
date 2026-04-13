import java.sql.*;

public class java_08992_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "username";
        String password = "password";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            String selectUsersQuery = "SELECT * FROM Users";
            ResultSet resultSet = statement.executeQuery(selectUsersQuery);

            while (resultSet.next()) {
                String userName = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.println("User Name: " + userName + ", Password: " + password);
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}