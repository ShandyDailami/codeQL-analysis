import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class java_31314_JDBCQueryHandler_A03 {
    private DataSource dataSource;
    private SessionFactory sessionFactory;

    public java_31314_JDBCQueryHandler_A03(DataSource dataSource) {
        this.dataSource = dataSource;
        this.sessionFactory = dataSource.getSessionFactory();
    }

    public Optional<String> findUserNameById(int id) {
        Optional<String> userName = Optional.empty();
        try (Session session = sessionFactory.openSession()) {
            userName = Optional.ofNullable(session.get(String.class, id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userName;
    }

    public void updateUserName(int id, String name) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            User user = session.get(User.class, id);
            if (user != null) {
                user.setName(name);
                session.update(user);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String> getAllUserNames() {
        List<String> userNames = null;
        try (Session session = sessionFactory.openSession()) {
            userNames = session.createQuery("FROM User", String.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userNames;
    }
}