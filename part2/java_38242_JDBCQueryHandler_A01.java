import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_38242_JDBCQueryHandler_A01 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "password";

        try {
            // Step 1: Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Establish connection pool
            ConnectionPool connectionPool = new ConnectionPool(url, username, password);

            // Step 3: Prepare statement
            Connection connection = connectionPool.getConnection();
            Statement statement = connection.createStatement();

            // Step 4: Execute SQL query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employees");

            // Step 5: Process ResultSet
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String name = resultSet.getString("name");
                System.out.println("ID: " + id + ", Name: " + name);
            }

            // Step 6: Close resources
            resultSet.close();
            statement.close();
            connectionPool.closeConnection(connection);

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}

class ConnectionPool {
    private String url;
    private String username;
    private String password;

    public java_38242_JDBCQueryHandler_A01(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}