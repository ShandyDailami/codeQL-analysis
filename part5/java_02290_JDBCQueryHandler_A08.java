import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_02290_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM my_table";

            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(query);

                while (resultSet.next()) {
                    System.out.println("Row 1: " + resultSet.getString("column1"));
                    System.out.println("Row 2: " + resultSet.getString("column2"));
                    // Add more columns as needed
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}