import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import com.mysql.jdbc.jdbc2.javasql.SQLException;

public class java_27023_SessionManager_A07 {

    private static final Logger LOGGER = Logger.getLogger(SessionManager.class.getName());

    private DataSource dataSource;

    public java_27023_SessionManager_A07(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void doSomething() {
        Session session = null;
        try {
            session = dataSource.getConnection().unwrap(Session.class);

            session.beginTransaction();

            // Here is where your code for A07_AuthFailure would go.
            // For example, authentication failure.

            session.getTransaction().commit();
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Error in the transaction:", ex);
            session.getTransaction().rollback();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}