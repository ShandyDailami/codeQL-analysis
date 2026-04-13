import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class java_38083_SessionManager_A03 {
    
    private SessionFactory sessionFactory;
    private Transaction transaction;

    public java_38083_SessionManager_A03() {
        configureSessionFactory();
    }

    private void configureSessionFactory() {
        Configuration configuration = new Configuration().configure();
        configuration.addAnnotatedClass(EntityClass.class); // replace EntityClass with your entity class
        sessionFactory = configuration.buildSessionFactory();
    }

    public void startTransaction() {
        transaction = transaction = sessionFactory.openSession().beginTransaction();
    }

    public void save(EntityClass entity) {
        sessionFactory.getCurrentSession().save(entity);
        transaction.commit();
    }

    public void update(EntityClass entity) {
        sessionFactory.getCurrentSession().update(entity);
        transaction.commit();
    }

    public void delete(EntityClass entity) {
        sessionFactory.getCurrentSession().delete(entity);
        transaction.commit();
    }

    public static void main(String[] args) {
        SessionManager sm = new SessionManager();
        sm.startTransaction();
        sm.save(new EntityClass("John", "Doe"));
        sm.update(new EntityClass("John", "Doe"));
        sm.delete(new EntityClass("John", "Doe"));
    }
}