import java.sql.*;

public class java_02532_JDBCQueryHandler_A01 {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // 1. Open a connection
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // 2. Create a statement
            Statement statement = connection.createStatement();

            // 3. Execute a SQL query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE name='John'");

            // 4. Process the result set
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String email = resultSet.getString("email");
                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
                System.out.println("Email: " + email);
            }

            // 5. Close the result set and the statement
            resultSet.close();
            statement.close();

            // 6. Close the connection
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}