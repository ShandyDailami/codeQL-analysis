import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_30484_JDBCQueryHandler_A03 {

    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void main(String[] args) {
        try {
            Connection connection = getConnection();
            // Here you can use the connection object for your queries
            // For example:
            String query = "SELECT * FROM users WHERE username = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, "testUser");
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                System.out.println(result.getString("password"));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}