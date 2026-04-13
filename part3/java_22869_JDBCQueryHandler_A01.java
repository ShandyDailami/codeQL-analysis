import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class java_22869_JDBCQueryHandler_A01 {
    public static void main(String[] args) {
        // Step 1: Establish a connection
        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/database_name", "username", "password")) {

            // Step 2: Prepare a statement
            try (Statement statement = connection.createStatement()) {

                // Step 3: Execute a query
                try (ResultSet resultSet = statement.executeQuery("SELECT * FROM table_name")) {

                    // Step 4: Process the result
                    while (resultSet.next()) {
                        System.out.println(resultSet.getString("column_name"));
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}