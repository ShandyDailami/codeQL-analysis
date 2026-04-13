import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_37216_SessionManager_A01 {
    private static final String URL = "jdbc:mysql://localhost:3306/test";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        Connection connection = null;
        try {
            // Step 1: Load MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Open a connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            // Step 3: Start a transaction
            connection.setAutoCommit(false);

            // Step 4: Perform a basic operation
            connection.prepareStatement("INSERT INTO EMPLOYEE (ID, NAME, AGE) VALUES (?, ?, ?)")
                    .executeUpdate();

            // Step 5: Commit the transaction
            connection.commit();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 6: Close the connection
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}