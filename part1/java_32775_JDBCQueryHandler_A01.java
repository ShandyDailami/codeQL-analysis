import java.sql.*;

public class java_32775_JDBCQueryHandler_A01 {
    private static final String URL = "jdbc:postgresql://localhost/test";
    private static final String USER = "username";
    private static final String PASS = "password";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASS);

            String query = "SELECT * FROM users WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, "admin"); // admin is a known good username

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");

                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }

            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}