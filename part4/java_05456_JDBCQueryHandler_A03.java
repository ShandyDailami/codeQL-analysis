import java.sql.*;

public class java_05456_JDBCQueryHandler_A03 {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private static ConnectionPool connectionPool;

    static {
        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

            connectionPool = new ConnectionPool(URL, USER, PASSWORD, "com.mysql.cj.jdbc.Driver");
        } catch (SQLException | DriverManagerException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String query = "SELECT * FROM users WHERE name = ?";

        try (Connection connection = connectionPool.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, "John Doe");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");

                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}