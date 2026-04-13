import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_26298_JDBCQueryHandler_A07 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM Users WHERE username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "exampleUser");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String user = resultSet.getString("username");
                System.out.println("User: " + user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}