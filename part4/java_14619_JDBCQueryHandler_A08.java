import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_14619_JDBCQueryHandler_A08 {

    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try {
            // Step 1: Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 3: Prepare a SQL query
            String query = "SELECT * FROM employees WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(query);

            // Step 4: Set parameters in the query
            statement.setInt(1, 1);

            // Step 5: Execute the query
            ResultSet result = statement.executeQuery();

            // Step 6: Process the result
            while (result.next()) {
                int id = result.getInt("id");
                String name = result.getString("name");
                System.out.println("ID: " + id + ", Name: " + name);
            }

            // Step 7: Close the connection
            connection.close();

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}