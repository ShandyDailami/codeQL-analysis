import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class java_24891_JDBCQueryHandler_A07 {

    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String username = "root";
    private static final String password = "password";

    private static Connection connection;

    static {
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String query = "SELECT * FROM users WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, 123);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                String name = result.getString("name");
                System.out.println("Name: " + name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}