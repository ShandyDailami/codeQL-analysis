import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class java_39847_JDBCQueryHandler_A07 {
    private Connection connection;

    public java_39847_JDBCQueryHandler_A07() {
        try {
            // Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Connection URL and credentials
            String url = "jdbc:mysql://localhost:3306/mydb";
            String username = "myuser";
            String password = "mypassword";

            // Open a connection
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public void executeQuery(String query) {
        Statement statement = null;
        try {
            // Create a new statement
            statement = connection.createStatement();

            // Execute the query
            statement.executeUpdate(query);

            System.out.println("Query executed successfully.");
        } catch (SQLException e) {
            System.out.println("Failed to execute query: " + e.getMessage());
        } finally {
            try {
                // Close the statement
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        handler.executeQuery("SELECT * FROM users WHERE username = 'test' AND password = 'test'");
    }
}