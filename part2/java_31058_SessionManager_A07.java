import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

public class java_31058_SessionManager_A07 {
    private HibernateTemplate hibernateTemplate;

    // Constructor
    public java_31058_SessionManager_A07(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    // Use transaction to ensure data integrity
    public void saveEntity(final Object entity) {
        hibernateTemplate.execute(new TransactionCallback<Object>() {
            public Object doInTransaction(TransactionStatus status) {
                hibernateTemplate.save(entity);
                return null;
            }
        });
    }

    public static void main(String[] args) {
        // Initializing Spring container
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

        // Retrieve sessionManager bean
        SessionManager sessionManager = context.getBean("sessionManager", SessionManager.class);

        // Test saving entity
        User user = new User();
        user.setName("Test User");
        sessionManager.saveEntity(user);

        context.close();
    }
}