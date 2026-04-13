import org.springframework.context.annotation.*;
// import for SessionFactory, EntityManager etc., used in Spring Data JPA (if using)  
@Configuration // This tells spring to look at this class java_49736_SessionManager_A03 creating the bean definitions objects inside it will auto load all beans defined by @Bean below and create a context where these managed services are available. 
public class AppConfig {   
    
	// SessionFactory Bean is created in our application-context file (src/main).   //(for hibernate) if using jpa or spring data JPA, this bean will be autowired into the service and repository classes where needed for database operations.  For H2 db connection etc., it would not need to create here as they are handled by Spring framework itself through its Configuration Class (AppConfig).  
    // SessionFactory Bean is created in our application-context file, if using spring security features like Role based Access Control or Security Interceptor feature.  It will be autowired into the services where needed for managing user roles and permissions within your app.     
    
	@Bean("sessionManager")   //Spring naming convention of defining bean by its id which can later reference this Bean in other beans/components via their annotation or xml file configuration, used to create a SessionFactory instance using the Hibernate settings (hibernatetestsettings) and stored it as an Application Context variable. 
	public DataSource dataSource() { //method for creating our database connection pool  
		//Here you can use any of your preferred ways such JDBC, C3P0 or even hikari etc..    using Spring's @Primary annotation will make this the default db source in case no other is specified. 
	}    
} // end AppConfig class and method definitions