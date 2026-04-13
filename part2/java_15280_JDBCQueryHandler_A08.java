import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_15280_JDBCQueryHandler_A08 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "username";
        String password = "password";

        try {
            // 1. Load MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Establish a connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // 3. Create a statement
            Statement statement = connection.createStatement();

            // 4. Execute a query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM mytable");

            // 5. Process the results
            while (resultSet.next()) {
                System.out.println("Row: " + resultSet.getInt("id") + ", " + resultSet.getString("name"));
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