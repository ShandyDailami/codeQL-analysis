import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_06726_JDBCQueryHandler_A01 {

    private Connection connection;
    private Statement statement;

    public java_06726_JDBCQueryHandler_A01() {
        init();
    }

    private void init() {
        try {
            // Step 1: Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish a connection
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/mydatabase",
                    "username",
                    "password");

            // Step 3: Create a statement
            statement = connection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeQuery(String query) {
        try {
            // Step 4: Execute the query
            ResultSet resultSet = statement.executeQuery(query);

            // Step 5: Process the ResultSet
            while (resultSet.next()) {
                System.out.println("Result: " + resultSet.getString("column_name"));
            }

            // Step 6: Close the connection
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}