import java.sql.*;

public class java_20892_JDBCQueryHandler_A03 {
    private static final String url = "jdbc:mysql://localhost:3306/test";
    private static final String username = "root";
    private static final String password = "password";
    private static Connection connection;

    public static void main(String[] args) {
        try {
            connection = DriverManager.getConnection(url, username, password);
            String query = "SELECT * FROM users WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, 123); // set the id
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                System.out.println(result.getString("name"));
            }

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}