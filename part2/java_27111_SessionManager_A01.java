import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.context.support.GenericBeanDefinition;

public class java_27111_SessionManager_A01 {

    public static void main(String[] args) {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext();
        context.registerBeanDefinition("sessionRegistry", new GenericBeanDefinition() {
            @Override
            public void setBeanDefinition(BeanDefinitionRegistryPostProcessor postProcessor) {
                // No need for customization
            }
        });
        context.refresh();

        SessionFactory sessionFactory = context.getBean(SessionFactory.class);
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        // Perform some operations here

        session.getTransaction().commit();
        session.close();

        context.close();
    }

}