import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_30247_JDBCQueryHandler_A03 {

    public static void main(String[] args) {
        String url = "jdbc:yourDatabaseURL";
        String username = "username";
        String password = "password";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            String query = "SELECT * FROM yourTable WHERE yourColumn = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            // Use parameterized query
            preparedStatement.setString(1, "yourValue");

            // Execute the query
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                // Handle the result set
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}