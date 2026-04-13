import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_16634_JDBCQueryHandler_A07 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "username";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery("SELECT * FROM my_table");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("column_name"));
            }

        } catch (SQLException e) {
            System.out.println("Error while connecting to database");
            e.printStackTrace();
        }
    }
}