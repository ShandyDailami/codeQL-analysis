import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class java_01281_SessionManager_A08 {
    private DataSource dataSource;

    public java_01281_SessionManager_A08(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void execute(Runnable task) {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            connection.setAutoCommit(false);
            task.run();
            connection.commit();
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