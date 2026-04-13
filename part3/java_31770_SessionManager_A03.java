import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class java_31770_SessionManager_A03 {

    public static void main(String[] args) {

        // Load the Spring application context file
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        // Obtain the session factory from the context
        SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");

        // Open a session
        Session session = sessionFactory.openSession();

        // Start transaction
        Transaction tx = session.beginTransaction();

        // Perform operations here

        // Commit the transaction
        tx.commit();

        // Close the session
        session.close();

    }
}