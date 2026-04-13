import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class java_09291_JDBCQueryHandler_A08 {
    private SecurityManager securityManager;

    public java_09291_JDBCQueryHandler_A08(SecurityManager securityManager) {
        this.securityManager = securityManager;
    }

    public ResultSet executeQuery(String query) {
        if (securityManager.isAllowedQueryExecution(Thread.currentThread().getContextClassLoader())) {
            try (Connection connection = DriverManager.getConnection("jdbc:your_database_url");
                 Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(query);
                return resultSet;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Access Denied: You are not authorized to execute this query.");
        }
        return null;
    }

    public void executeUpdate(String query) {
        if (securityManager.isAllowedUpdateExecution(Thread.currentThread().getContextClassLoader())) {
            try (Connection connection = DriverManager.getConnection("jdbc:your_database_url");
                 Statement statement = connection.createStatement()) {
                statement.executeUpdate(query);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Access Denied: You are not authorized to execute this update.");
        }
    }
}