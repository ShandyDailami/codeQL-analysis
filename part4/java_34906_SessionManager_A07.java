import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class java_34906_SessionManager_A07 {

    public static void main(String[] args) {
        // Load the spring configuration file
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        // Get the session bean
        SessionBean sessionBean = context.getBean("sessionBean", SessionBean.class);

        // Use the session bean
        sessionBean.doSomething("Hello World!");

        // Close the context
        ((AnnotationConfigApplicationContext) context).close();
    }
}