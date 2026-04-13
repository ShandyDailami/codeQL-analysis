import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class java_14263_JDBCQueryHandler_A07 {

    // Step 1: Declare and initialize the connection object
    private Connection connection = null;
    private Statement stmt = null;

    // Step 2: Establish the connection with the database
    public java_14263_JDBCQueryHandler_A07() {
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "root";

        try {
            connection = DriverManager.getConnection(url, username, password);
            stmt = connection.createStatement();
        } catch (SQLException e) {
            System.out.println("Error connecting to the database");
            e.printStackTrace();
        }
    }

    // Step 3: Execute a query on the database
    public void executeQuery(String query) {
        try {
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("Error executing query: " + query);
            e.printStackTrace();
        }
    }

    // Step 4: Close the connection
    public void close() {
        try {
            if (stmt != null) stmt.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
            System.out.println("Error closing the connection");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler jdbcQueryHandler = new JDBCQueryHandler();

        String query = "INSERT INTO users (username, password) VALUES ('user1', 'pass1')";
        jdbcQueryHandler.executeQuery(query);

        jdbcQueryHandler.close();
    }
}