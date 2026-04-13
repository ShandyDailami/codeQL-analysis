import java.sql.*;

public class java_00199_JDBCQueryHandler_A07 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "username";
        String password = "password";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Users WHERE username = 'testuser' AND password = 'testpassword'");

            while (resultSet.next()) {
                System.out.println("User found!");
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}