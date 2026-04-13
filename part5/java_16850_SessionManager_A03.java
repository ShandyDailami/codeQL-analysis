import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class java_16850_SessionManager_A03 {

    private SessionFactory sessionFactory;

    private java_16850_SessionManager_A03() {
        Configuration configuration = new Configuration().configure();
        sessionFactory = configuration.buildSessionFactory();
    }

    public static SessionManager getInstance() {
        return Holder.INSTANCE;
    }

    private static class Holder {
        private static final SessionManager INSTANCE = new SessionManager();
    }

    public Session getSession() {
        return sessionFactory.openSession();
    }

    public void save(Object object) {
        Session session = getSession();
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();
        session.close();
    }

    public <T> T find(Class<T> clazz, Object id) {
        Session session = getSession();
        return session.get(clazz, id);
    }

    public void update(Object object) {
        Session session = getSession();
        session.beginTransaction();
        session.update(object);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(Object object) {
        Session session = getSession();
        session.beginTransaction();
        session.delete(object);
        session.getTransaction().commit();
        session.close();
    }

    public List<Object> query(String hql) {
        Session session = getSession();
        org.hibernate.query.Query query = session.createQuery(hql);
        List<Object> resultList = query.list();
        session.close();
        return resultList;
    }
}