import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class java_10903_JDBCQueryHandler_A08 {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "myuser";
        String password = "mypassword";

        try {
            // Step 1: Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection to the database
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 3: Create a statement object
            Statement statement = connection.createStatement();

            // Step 4: Execute a SQL query
            String sql = "SELECT * FROM mytable";
            ResultSet resultSet = statement.executeQuery(sql);

            // Step 5: Process the result set
            while (resultSet.next()) {
                System.out.println("Row: " + resultSet.getString("myfield"));
            }

            // Step 6: Close the connection
            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}