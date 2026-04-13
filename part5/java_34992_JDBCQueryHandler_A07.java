import java.sql.*;

public class java_34992_JDBCQueryHandler_A07 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "username";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();

            String selectQuery = "SELECT * FROM Users WHERE id = ?";
            ResultSet resultSet = statement.executeQuery(selectQuery);

            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");

                // Perform security-sensitive operations here
                // ...

                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}