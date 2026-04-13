import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criteria.CriteriaBuilder;
import org.hibernate.criteria.CriteriaSpecification;
import org.hibernate.criterion.Restrictions;

public class java_21928_SessionManager_A03 {

    private SessionFactory sessionFactory;

    public java_21928_SessionManager_A03(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void store(Object object) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
        session.close();
    }

    public <T> T retrieve(Class<T> clazz, Object id) {
        Session session = sessionFactory.openSession();
        T object = session.get(clazz, id);
        session.close();
        return object;
    }

    public void update(Object object) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(object);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(Object object) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(object);
        session.getTransaction().commit();
        session.close();
    }

    public <T> List<T> findByCriteria(Class<T> clazz, CriteriaSpecification criteria) {
        Session session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaSpecification criteriaQuery = criteria.toCriteriaSpecification(builder);
        List<T> result = session.createQuery(criteriaQuery).list();
        session.close();
        return result;
    }
}