import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_24711_JDBCQueryHandler_A03 {

    private final String DB_URL;
    private final String USER;
    private final String PASSWORD;

    public java_24711_JDBCQueryHandler_A03(String dbUrl, String user, String password) {
        this.DB_URL = dbUrl;
        this.USER = user;
        this.PASSWORD = password;
    }

    public void executeQuery(String query) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.executeUpdate();
            System.out.println("Query executed successfully");
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        } finally {
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
            } catch (SQLException e) {
                System.out.println("Error closing statement: " + e.getMessage());
            }
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                System.out.println("Error closing connection: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler queryHandler = new JDBCQueryHandler("jdbc:mysql://localhost:3306/testdb", "username", "password");
        queryHandler.executeQuery("SELECT * FROM Users WHERE username = 'test'");
    }
}