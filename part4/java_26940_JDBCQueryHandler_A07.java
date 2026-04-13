import java.sql.*;

public class java_26940_JDBCQueryHandler_A07 {

    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();

            String sql = "SELECT * FROM Users WHERE username = 'test' AND password = 'test'";
            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                System.out.println("Authentication successful!");
            } else {
                System.out.println("Authentication failed!");
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}