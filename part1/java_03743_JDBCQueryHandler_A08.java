import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_03743_JDBCQueryHandler_A08 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/dbname";
        String username = "username";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT * FROM table_name WHERE integrity_column = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "value");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                // handle the result set
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}