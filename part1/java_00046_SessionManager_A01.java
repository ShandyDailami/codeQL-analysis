import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_00046_SessionManager_A01 {
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        try {
            // Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create a new connection
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Create a new session
            Session session = new Session(connection);

            // Access a database-protected resource
            session.accessDatabaseResource();

            // Close the connection
            session.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}

class Session {
    private Connection connection;

    public java_00046_SessionManager_A01(Connection connection) {
        this.connection = connection;
    }

    public void accessDatabaseResource() throws SQLException {
        // Simulate accessing a database resource
        connection.createStatement().execute("SELECT * FROM protected_table");
        System.out.println("Database access successful");
    }

    public void close() throws SQLException {
        if (connection != null && connection.isClosed()) {
            connection.close();
        }
    }
}