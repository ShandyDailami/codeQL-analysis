import java.sql.*;

public class java_36437_JDBCQueryHandler_A07 {

    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USER = "myuser";
    private static final String PASSWORD = "mypassword";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Users WHERE username = 'user1' AND password = 'pass1'");

            while (resultSet.next()) {
                System.out.println("User found: " + resultSet.getString("username"));
            }

            connection.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
       
        }
    }
}