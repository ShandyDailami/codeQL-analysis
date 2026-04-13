import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_03625_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "username";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT * FROM my_table WHERE my_condition";
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM my_table WHERE my_condition");
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                // Process the result set here
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}