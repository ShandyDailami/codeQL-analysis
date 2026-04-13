import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class java_23281_JDBCQueryHandler_A03 {
    private DataSource dataSource;

    public java_23281_JDBCQueryHandler_A03(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void executeQuery(String query) {
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            System.err.println("Error executing query: " + e.getMessage());
        }
    }
}