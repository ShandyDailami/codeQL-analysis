import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class java_02479_SessionManager_A03 {
    private static SessionFactory sessionFactory;

    public static Session getSession() {
        return sessionFactory.openSession();
    }

    public static void main(String[] args) {
        // Load the Hibernate configuration file
        Configuration configuration = new Configuration().configure();

        // Create the SessionFactory
        sessionFactory = configuration.buildSessionFactory();

        // Get a session
        Session session = getSession();

        // Create a CriteriaBuilder
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

        // Create a CriteriaQuery
        CriteriaQuery<Session> criteriaQuery = criteriaBuilder.createQuery(Session.class);

        // Create a Root
        Root<Session> root = criteriaQuery.from(Session.class);

        // Add a restriction to the query
        criteriaQuery.select(root);

        // Execute the query and get the result
        List<Session> sessions = session.createQuery(criteriaQuery).list();

        // Print the result
        for (Session session1 : sessions) {
            System.out.println(session1.getId());
        }

        // Close the session
        session.close();
    }
}