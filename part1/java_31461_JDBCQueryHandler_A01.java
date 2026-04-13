import java.sql.*;

public class java_31461_JDBCQueryHandler_A01 {
    private static final String URL = "jdbc:postgresql://localhost:5432/mydatabase";
    private static final String USER = "myuser";
    private static final String PASSWORD = "mypassword";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement statement = connection.createStatement()) {

            String sql = "SELECT * FROM mytable"; // replace with your SQL query
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                // process each row of result set
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                // ... handle data
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}