import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_30891_JDBCQueryHandler_A03 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testDB";
        String username = "root";
        String password = "password";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sql = "INSERT INTO students (id, name) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            // Set the parameters for the SQL query
            statement.setInt(1, 1); // id
            statement.setString(2, "John Doe"); // name

            // Execute the query
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}