import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class java_10185_SessionManager_A07 {

    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Accessing SessionFactory from the context
        SessionFactory sessionFactory = context.getBean("sessionFactory", SessionFactory.class);

        // Creating new Session from the SessionFactory
        Session session = sessionFactory.openSession();

        // Starts the session
        session.beginTransaction();

        // Your code here...

        // Committing the transaction
        session.getTransaction().commit();

        // Closing the session
        session.close();

        // Closing the context
        context.close();
    }

    public static class AppConfig {

        // Setting up the configuration here...

    }

}