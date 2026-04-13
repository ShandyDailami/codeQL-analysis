import java.sql.*;
import java.util.Properties;

public class java_16315_JDBCQueryHandler_A03 {

    private static Connection connection = null;
    private static Statement statement = null;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // assuming mysql driver

            Properties properties = new Properties();
            properties.setProperty("user", "username");
            properties.setProperty("password", "password");
            properties.setProperty("useSSL", "false");
            properties.setProperty("verifyServerCertificate", "false");
            properties.setProperty("requireSSL", "false");

            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", properties);
            statement = connection.createStatement();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            String query = "SELECT * FROM users WHERE username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "testUser");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.println("Username: " + username + ", Password: " + password);
            }

            resultSet.close();
            preparedStatement.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}