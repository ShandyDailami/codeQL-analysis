import java.sql.*;

public class java_11190_JDBCQueryHandler_A03 {

    // This is our main method where we'll execute the query.
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "password";

        // Establish a connection to the database.
        try (Connection connection = DriverManager.getConnection(url, username, password)) {

            // Perform a query.
            try (Statement statement = connection.createStatement()) {
                String sql = "SELECT * FROM mytable";
                ResultSet resultSet = statement.executeQuery(sql);

                // Process the result set.
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    System.out.println("id: " + id + ", name: " + name);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}