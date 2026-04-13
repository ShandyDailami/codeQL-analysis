import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_34249_JDBCQueryHandler_A01 {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            System.out.println("Connected to the database!");
        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
            return;
        }

        try {
            String query = "INSERT INTO test_table (test_column) VALUES (?)";
            connection.prepareStatement(query).setString(1, "test").executeUpdate();
            System.out.println("Inserted into test_table!");

            query = "SELECT * FROM test_table WHERE test_column = ?";
            connection.prepareStatement(query).setString(1, "test").executeQuery();
            System.out.println("Selected from test_table!");
        } catch (SQLException e) {
            System.out.println("Query execution failed!");
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                    System.out.println("Connection closed!");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}