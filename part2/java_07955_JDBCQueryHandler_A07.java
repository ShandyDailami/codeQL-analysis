import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_07955_JDBCQueryHandler_A07 {
    // a.
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password";

    // b.
    private Connection connection;
    private Statement statement;

    // c.
    public java_07955_JDBCQueryHandler_A07() {
        try {
            // a.
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // d.
    public void executeQuery(String query) {
        try {
            // e.
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                // f.
                System.out.println(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // a.
    public void closeConnection() {
        try {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // b.
    public static void main(String[] args) {
        VanillaJDBCQueryHandler handler = new VanillaJDBCQueryHandler();
        handler.executeQuery("SELECT * FROM users");
        handler.closeConnection();
    }
}