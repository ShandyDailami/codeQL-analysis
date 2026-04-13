import javax.sql.DataSource;
import javax.sql.Session;
import javax.sql.SessionFactory;
import javax.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;

public class java_00686_SessionManager_A08 {

    private SessionFactory sessionFactory;

    public java_00686_SessionManager_A08(DataSource dataSource) {
        this.sessionFactory = dataSource.getSessionFactory();
    }

    public void openSession(Runnable callback) {
        Connection connection = null;
        Session session = null;

        try {
            connection = sessionFactory.getConnection();
            session = connection.newSession();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
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