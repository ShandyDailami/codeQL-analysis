import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_30442_JDBCQueryHandler_A03 {

    public void executeQuery(String url, String username, String password) throws SQLException {
        // Step 1: Register JDBC driver
        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

        // Step 2: Establish a connection to the database
        Connection connection = DriverManager.getConnection(url, username, password);

        // Step 3: Prepare a statement
        Statement statement = connection.createStatement();

        // Step 4: Execute a SQL query
        ResultSet resultSet = statement.executeQuery("SELECT * FROM YourTable");

        // Step 5: Process the results
        while (resultSet.next()) {
            System.out.println("ID: " + resultSet.getInt("id"));
            System.out.println("Name: " + resultSet.getString("name"));
            // You can process other columns as well
        }

        // Step 6: Cleanup
        resultSet.close();
        statement.close();
        connection.close();
    }

    public static void main(String[] args) {
        try {
            new JDBCQueryHandler().executeQuery("jdbc:mysql://localhost:3306/mydb", "username", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}