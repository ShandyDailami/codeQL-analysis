import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_15692_JDBCQueryHandler_A01 {

    // URL, username, and password for your database
    private static final String url = "jdbc:your_database_url";
    private static final String username = "your_username";
    private static final String password = "your_password";

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // 1. Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Establish a connection
            connection = DriverManager.getConnection(url, username, password);

            // 3. Create a statement
            preparedStatement = connection.prepareStatement("SELECT * FROM sensitive_data");

            // 4. Execute the statement
            ResultSet resultSet = preparedStatement.executeQuery();

            // 5. Process the result set
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String data = resultSet.getString("data");
                System.out.println("ID: " + id + ", Data: " + data);
            }

            // 6. Close the statement and connection
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}