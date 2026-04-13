import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_33108_JDBCQueryHandler_A01 {

    private Connection connection;

    public java_33108_JDBCQueryHandler_A01() {
        connectToDatabase();
    }

    private void connectToDatabase() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "username", "password");
        } catch (SQLException e) {
            System.out.println("Failed to connect to database: " + e.getMessage());
        }
    }

    public void executeQuery(String query) {
        try {
            if (connection != null && !connection.isClosed()) {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);

                while (resultSet.next()) {
                    System.out.println("Result: " + resultSet.getString("name"));
                }
            } else {
                System.out.println("Connection is closed.");
            }
        } catch (SQLException e) {
            System.out.println("Failed to execute query: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        JDBCQueryHandler handler = new JDBCQueryHandler();
        handler.executeQuery("SELECT * FROM Users");
    }
}