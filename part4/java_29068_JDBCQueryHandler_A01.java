import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_29068_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "username";
        String password = "password";

        try {
            // 1. Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Open a connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // 3. Create a statement
            Statement statement = connection.createStatement();

            // 4. Execute a query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE role='admin'");

            // 5. Process the result
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.println("Username: " + username);
                System.out.println("Password: " + password);
            }

            // 6. Close the connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}