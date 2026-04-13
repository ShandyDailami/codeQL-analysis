import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class java_30899_JDBCQueryHandler_A08 {

    // JDBC driver name and database URL
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";

    // Database credentials
    private static final String USER = "root";
    private static final String PASS = "password";

    public java_30899_JDBCQueryHandler_A08() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            // Step 1: Register JDBC driver
            Class.forName(DB_DRIVER);

            // Step 2: Establish the connection
            connection = DriverManager.getConnection(DB_URL, USER, PASS);

            // Step 3: Prepare statement
            String sql = "INSERT INTO EMPLOYEE (ID, NAME, AGE) VALUES (?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);

            // Setin data
            preparedStatement.setInt(1, 101);
            preparedStatement.setString(2, "John");
            preparedStatement.setInt(3, 28);

            // Step 4: Execute the query
            preparedStatement.executeUpdate();

            System.out.println("Record inserted successfully");
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
            } catch (SQLException se2) {
            }
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}