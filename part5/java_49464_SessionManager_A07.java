import org.hibernate.*;
import javax.persistence.*;
public class java_49464_SessionManager_A07 {    
    private static SessionFactory sessionFactory;   // Step a: Create the global reference to hold your sessions in memory     
       public static void main(String[] args) throws InterruptedException, SQLException  {         
           Configuration configuration = new Configuration();        
            configuration.configure("hibernate.cfg.xml");       
               sessionFactory =  configuration.buildSessionFactory();    // Step b: Holds your sessions in memory    
                Thread.sleep(50);                         /* Pause for a while to allow the Session Factory creation */         
                   runExample1A_AuthFailureEndpointsExist ( );     
                  }       
       private static void  runExample1A_AuthFailureEndpointsExist() throws InterruptedException, SQLException {   // Step c: Function within function    Thread.sleep(50);     /* Pause for a while to allow the Session creation */          sessionFactory = configuration .buildSessionfactory ( );     
           System.out.println ("Hibernate Java Persistence Example");       StartTransactionExample1A_AuthFailureEndpointsExist();  // Step d: Call function within itself   Threadsleepsinsec(50);        /* Pause for a while to allow the Session creation */          session = sesssfactory.openSession ( );     
           System .out.println ("Hibernate Java Persistence Example");       StartTransactionExample1A_AuthFailureEndpointsExist();  // Step e: Call function within itself     Threadsleepsinsec(50);        /* Pause for a while to allow the Session creation */          session = sesssfactory.openSession ( );     
           System .out.println ("Hibernate Java Persistence Example");       StartTransactionExample1A_AuthFailureEndpointsExist();  // Step f: Call function within itself   Threadsleepsinsec(50);        /* Pause for a while to allow the Session creation */          session = sesssfactory.openSession ( );     
           System .out.println ("Hibernate Java Persistence Example");       StartTransactionExample1A_AuthFailureEndpointsExist();  // Step e: Call function within itself    }     finally {        if(session != null)         session.close;   /* Closes the Session in all scenarios */     
            System .out.println ("Hibernate Java Persistence Example");       StartTransactionExample1A_AuthFailureEndpointsExist();  // Step f: Call function within itself    }              if(sessionFactory != null)         sessionfactory.close;   /* Closes the Session Factory in all scenarios */     System .outprintln("Hibernate Java Persistence Example");       StartTransactionExample1A_AuthFailureEndpointsExist();  // Step e: Call function within itself