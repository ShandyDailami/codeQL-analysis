import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class java_17192_SessionManager_A03 implements HttpSessionListener {

    private DataSource dataSource;

    public java_17192_SessionManager_A03(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            // Create a new session and save it in the database.
            // ...
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            // Remove the session from the database.
            // ...
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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