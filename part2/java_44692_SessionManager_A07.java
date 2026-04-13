import org.hibernate.*;    // Import Hibernates SessionFactory API (Session) & annotations(e.g., @Entity etc.) 
import javax.persistence.*;     // For Entity management, required by hibenate's session factory and entity classes defined here...  
                                  
public class java_44692_SessionManager_A07 {   
       private static final String PERSISTENCE_UNIT_NAME = "example";      // Persistence Unit Name which is used to create SessionFactory  (it must match with one in persistence.xml)    
       
       @PersistenceUnit(name=PERSISTENCE_UNIT_NAME)    private static EntityManagerFactory emf;   // Hibernate's API for the database connection, which is obtained through a Persistennce Unit  (defined above in PERSISTENCE UNIT NAME).
       
       public AuthFailure addUser(String username , String password){     /* Secure method to store new user. */   
         Session session = emf.openSession();   // Opening up the current/session with DB for database operations  (required by hibernate's CRUD functionalities)     
          Transaction tx  = null;               // Holds transaction details, required in any kind of operation involving JDBC    
         try(session){                            /* Starting new Session and executing a method on the object */   
             User user =new  User();            // create hibernate entity for storing data   (Defined as @Entity below)      
               tx =  session.beginTransaction();// Begin transaction -> start database operations      e    
              ((GenericEntity<?>)user).detach();        /* Detaching the instance and save it to DB only */   
             user.setUsername(username);  // setting username   (Defined below as a private variable with getter & setters methods defined in User class.)      
            user.setPassword(password );         // saving password into db     (Again, Detached the instance and saved it only to DB)   
             session.save(user);                  /* Saving/Updating data on database*/   try{      tx.commit(); }catch(Exception e){e.printStackTrace()}  finally { if(tx != null && tx.isActive()) tx.rollback(); } return user;   
         }}     // Closing session and transaction (defining a method inside class)       catch block will handle exceptions, roll-backs any transactions in case of failure/exceptions are caught here      finally { if(tx != null && tx.isActive()) …}   }) }catch......