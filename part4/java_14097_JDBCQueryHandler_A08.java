import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_14097_JDBCQueryHandler_A08 {

    private static final String URL = "your_database_url";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    public static void main(String[] args) {
        String username = "your_username";
        String password = "your_password";

        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String query = "SELECT PASSWORD FROM USERS WHERE USERNAME = ?";

            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, username);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String dbPassword = resultSet.getString("PASSWORD");
                if (password.equals(dbPassword)) {
                    System.out.println("Access granted!");
                } else {
                    System.out.println("Access denied!");
                }
            } else {
                System.out.println("No such user found!");
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}