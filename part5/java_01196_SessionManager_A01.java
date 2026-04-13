import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class java_01196_SessionManager_A01 {

    private static AbstractApplicationContext context;

    static {
        // Load the Spring configuration file
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    public static void main(String[] args) {
        // Access a bean from the Spring context
        MyService myService = context.getBean("myService", MyService.class);

        // Use the bean
        System.out.println(myService.getMessage());

        // Close the context
        context.close();
    }

}