import org.springframework.context.annotation.*;
@Configuration // This indicates a configuration class java_48042_SessionManager_A01 Spring Framework context and can be scanned by the application ContextsAnnotationBeanPostProcessor bean post processor which is part of Component Scanning concept implemented via @ComponentScan annotation with basePackages or value attributes specified on your main ApplicationContext file  (as an example).
@EnableAspectJAutoProxy // Enables proxy creation for cross-cutting concerns.
public class AppConfig {    }   /* end Configuration */