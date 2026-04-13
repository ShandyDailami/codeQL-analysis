import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_19477_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        String url = "jdbc:your_database_url";
        String username = "username";
        String password = "password";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            String sql = "SELECT * FROM table_name"; // Replace with your SQL query
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                System.out.println(resultSet.getString("column_name")); // Replace with your column names
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}