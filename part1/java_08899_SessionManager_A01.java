import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class java_08899_SessionManager_A01 {
    private SessionFactory sessionFactory;

    public java_08899_SessionManager_A01(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Object executeSecurityOperation(String operation, Object param) {
        Session session = null;
        Transaction transaction = null;
        Object result = null;

        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();

            result = session.selectOne(operation, param);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return result;
    }
}