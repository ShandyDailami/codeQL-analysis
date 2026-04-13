import java.sql.*;

public class java_07996_JDBCQueryHandler_A01 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb"; // Change this with your database info
        String username = "root"; // Change this with your username
        String password = "password"; // Change this with your password

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String query = "SELECT * FROM Users"; // Change this with your query

            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(query);

                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    int age = resultSet.getInt("age");
                    String email = resultSet.getString("email");

                    System.out.println("Name: " + name);
                    System.out.println("Age: " + age);
                    System.out.println("Email: " + email);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error while connecting to the database: " + e.getMessage());
        }
    }
}