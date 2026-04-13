import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_16397_JDBCQueryHandler_A03 {
    private static final String URL = "jdbc:your-database-url";
    private static final String USER = "user";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM your_table")) {

            while (resultSet.next()) {
                System.out.println("Row data: " + resultSet.getString("your_column_name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}