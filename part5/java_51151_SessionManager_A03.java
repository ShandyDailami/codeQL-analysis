import org.hibernate.*;
import javax.persistence.*;
  
public class java_51151_SessionManager_A03 {    
    private static final String PERSISTENCE_UNIT = "example"; // Your persistence unit name, it should match in your application context file (META-INF/persistence.xml) 
                                                            /* Change this to the one you've used */  
     
    public SessionFactory sessionFactory;    
      
    @PersistenceUnit(name = PERSISTENCE_UNIT ) // Persisten unit name and location should match with your persitence-unit in application context file (META-INF/persistence.xml)  /* Change this to the one you've used */  
     public void setPersistenceUnit(PersistenceUnitInfo info){        
        sessionFactory =info .<SessionFactory>createSessionFactory();    } // Calling Session Factory from Persisten Unit Info            
     
       @SuppressWarnings("deprecation")  private static final long serialVersionUID = 1L;     public void close() {sessionFactory.close();}   /* This is not required and its deprecated */                                                           }    // Closing Session Factory, it's recommended to use the JPA specific APIs instead