import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_27814_JDBCQueryHandler_A03 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/db";
        String username = "username";
        String password = "password";

        try {
            // Step 1: Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open a connection to MySQL database
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 3: Execute a SQL query
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE username = '" + args[0] + "' AND password = '" + args[1] + "'");

            // Step 4: Process the result set
            while (resultSet.next()) {
                System.out.println("User found: " + resultSet.getString("username"));
            }

            // Step 5: Close the connection
            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}