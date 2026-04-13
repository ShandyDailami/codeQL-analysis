import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_21059_SessionManager_A08 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "root";

        try {
            // Step 1: Establish a connection
            Connection connection = DriverManager.getConnection(url, username, password);

            // Step 2: Use the connection to create a statement
            String query = "SELECT value FROM MyTable WHERE id = 1";
            PreparedStatement statement = connection.prepareStatement(query);

            // Step 3: Execute the statement
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String value = resultSet.getString(1);
                System.out.println("Value: " + value);
            }

            // Step 4: Close the statement and connection
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}