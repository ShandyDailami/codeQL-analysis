import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_25111_JDBCQueryHandler_A07 {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String sql = "SELECT * FROM User WHERE username = ? AND password = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "user1");
            statement.setString(2, "password1");
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                System.out.println("Valid user");
            } else {
                System.out.println("Invalid user");
            }
            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("Error while connecting to database or executing query");
            e.printStackTrace();
        }
    }
}