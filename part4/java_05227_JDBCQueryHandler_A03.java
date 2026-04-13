import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_05227_JDBCQueryHandler_A03 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "password";

        try {
            // Step 1: Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 3: Prepare a SQL statement
            String sql = "SELECT * FROM employees";
            PreparedStatement statement = connection.prepareStatement(sql);

            // Step 4: Execute the SQL statement
            ResultSet result = statement.executeQuery();

            // Step 5: Process the result
            while (result.next()) {
                String name = result.getString("name");
                int age = result.getInt("age");
                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
            }

            // Step 6: Close the connection
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}