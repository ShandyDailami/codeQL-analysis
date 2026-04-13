import java.sql.*;

public class java_27731_JDBCQueryHandler_A08 {
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "myuser";
    private static final String PASSWORD = "mypassword";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();

            // Example of a potentially dangerous query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Users WHERE Password = 'password'");

            while (resultSet.next()) {
                String username = resultSet.getString("Username");
                System.out.println("Username: " + username);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}