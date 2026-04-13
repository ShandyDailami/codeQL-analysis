import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_12867_JDBCQueryHandler_A08 {
    public static void main(String[] args) {
        try {
            // Step 1: Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mydatabase",
                    "username",
                    "password"
            );

            // Step 3: Prepare a statement
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM my_table WHERE id = ?");

            // Step 4: Set the parameter value
            statement.setInt(1, 123);

            // Step 5: Execute the statement
            ResultSet resultSet = statement.executeQuery();

            // Step 6: Process the result
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Name: " + resultSet.getString("name"));
            }

            // Step 7: Close the connection
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}