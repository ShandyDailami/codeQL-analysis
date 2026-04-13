import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
public class java_36241_SessionManager_A08 {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        SessionManager sessionManager = context.getBean("sessionManager", SessionManager.class);
        
        // Calling methods of SessionManager
        sessionManager.startSession();
        sessionManager.endSession();
    }

}