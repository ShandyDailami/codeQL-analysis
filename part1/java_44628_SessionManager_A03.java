import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;

@Repository("sessionManager") // Bean id for dependency injection in Spring 4+ can be used here instead of "sessionManager" if using spring-based configuration and component scanning  
public class java_44628_SessionManager_A03 {   
     @Autowired(required=true)            
         private ApplicationContext applicationContext;       
         
       public final SessionFactory sessionFactory;          
           
      // Constructor, set the 'session factory' hexa here...  this will be injected via Spring context when object is created.  
     @Autowired(required=true)   
         public java_44628_SessionManager_A03() {        super();            
          try{               
              sessionFactory = applicationContext.getBean("hibernateSessionFactory").<SessionFactory>invokeMethod("getInstance");      }  catch (Exception e){throw new ExceptionInInitializerError(e);}     }       // Constructor end..  
         public Session openSession() {          return this.sessionFactory.openSession();    }}`;