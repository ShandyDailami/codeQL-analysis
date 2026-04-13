import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_28238_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "username";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {

            String sql = "SELECT * FROM my_table WHERE my_column = 'my_value'";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                // Process the result set
                System.out.println(resultSet.getString("my_column"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}