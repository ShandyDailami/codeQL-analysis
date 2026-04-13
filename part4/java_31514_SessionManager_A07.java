import java.util.Optional;
import java.util.function.Function;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_31514_SessionManager_A07 {

    private final DataSource dataSource;
    private final SessionFactory sessionFactory;

    public java_31514_SessionManager_A07(DataSource dataSource) {
        this.dataSource = dataSource;
        this.sessionFactory = createSessionFactory();
    }

    private SessionFactory createSessionFactory() {
        return new Configuration().configure().buildSessionFactory();
    }

    public <T> Optional<T> withTransaction(Function<Session, T> function) {
        Session session = sessionFactory.openSession(dataSource.getConnection());
        T result;
        try {
            session.beginTransaction();
            result = function.apply(session);
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            throw e;
        } finally {
            session.close();
        }
        return Optional.ofNullable(result);
    }

    public User loadUser(String username) {
        return withTransaction(session -> session.get(User.class, username));
    }

    public void saveUser(User user) {
        withTransaction(session -> session.save(user));
    }
}