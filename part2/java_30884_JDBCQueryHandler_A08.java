import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_30884_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sql = "SELECT * FROM Users WHERE id = ?";
            java.sql.Statement statement = connection.createStatement();
            java.sql.ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");

                System.out.println("id: " + id);
                System.out.println("name: " + name);
                System.out.println("email: " + email);
            }
        } catch (SQLException e) {
            System.out.println("Error in accessing the database");
            e.printStackTrace();
        }
    }
}