import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_22644_JDBCQueryHandler_A01 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "myusername";
        String password = "mypassword";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery("SELECT * FROM myTable");

            while (resultSet.next()) {
                String column1 = resultSet.getString("column1");
                String column2 = resultSet.getString("column2");
                // Do something with the data...
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}