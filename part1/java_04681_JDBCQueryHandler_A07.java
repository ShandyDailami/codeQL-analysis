import java.sql.*;

public class java_04681_JDBCQueryHandler_A07 {
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();

            String sql = "SELECT * FROM Users WHERE username = 'test' AND password = 'test'";
            ResultSet result = statement.executeQuery(sql);

            if (result.next()) {
                System.out.println("Authentication successful.");
            } else {
                System.out.println("Authentication failed.");
            }

            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
        }
    }
}