import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_16550_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM table_name WHERE column_name = ?";
            try (java.sql.PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, 123); // example value
                java.sql.ResultSet result = statement.executeQuery();

                while (result.next()) {
                    System.out.println(result.getString("column_name"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}