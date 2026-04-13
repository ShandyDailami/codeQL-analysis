import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class java_18376_JDBCQueryHandler_A01 {

    // The URL, username, and password should never be hardcoded into your program.
    // They should be stored in a configuration file or environment variables.
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private Connection connection;

    public java_18376_JDBCQueryHandler_A01() {
        this.connect();
    }

    private void connect() {
        try {
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database");
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void execute(String query) {
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.execute();
        } catch (SQLException e) {
            System.out.println("Failed to execute query: " + query);
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query) {
        try {
            PreparedStatement statement = connection.prepareStatement(query);
            return statement.executeQuery();
        } catch (SQLException e) {
            System.out.println("Failed to execute query: " + query);
            e.printStackTrace();
            return null;
        }
    }

    public void close() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            System.out.println("Failed to close connection");
            e.printStackTrace();
        }
    }

    // This is a simple example of how you might use this class.
    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        ResultSet resultSet = handler.executeQuery("SELECT * FROM users WHERE email = ?");

        try {
            while (resultSet.next()) {
                String email = resultSet.getString("email");
                System.out.println("Email: " + email);
            }
        } catch (SQLException e) {
            System.out.println("Failed to iterate over result set");
            e.printStackTrace();
        } finally {
            handler.close();
        }
    }
}