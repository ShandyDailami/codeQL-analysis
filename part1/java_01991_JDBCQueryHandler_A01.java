import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_01991_JDBCQueryHandler_A01 {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // 1. Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Establish connection
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // 3. Create a statement
            Statement statement = connection.createStatement();

            // 4. Execute a SQL query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE username = 'admin' AND password = 'password'");

            // 5. Process the result
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }

            // 6. Close connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}