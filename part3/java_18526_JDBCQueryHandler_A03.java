import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_18526_JDBCQueryHandler_A03 {

    // Connection URL and credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASS = "password";

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // 1. Establish a connection
            connection = DriverManager.getConnection(DB_URL, USER, PASS);

            // 2. Prepare the SQL query
            String sql = "INSERT INTO USERS (ID, NAME, AGE) VALUES (?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);

            // 3. Execute the query
            preparedStatement.setInt(1, 20);
            preparedStatement.setString(2, "John");
            preparedStatement.setInt(3, 25);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 4. Close the connection
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
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