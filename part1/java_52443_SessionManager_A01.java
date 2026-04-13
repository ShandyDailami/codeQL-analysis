import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.HibernateException;
// import your session and entity classes here... 
public class java_52443_SessionManager_A01 {
    private static final SessionFactory sessionFactory; // assuming you have a defined Hibernate configuration file for this instance  
    
    /*static block to load the session factory, making it thread safe */     
       static {         
           try{             
               Configuration conf = new Configuration();                 
                conf.configure("hibernate-config.xml"); // assume you have a hibernete configuration file named "hibernate-config.xml"                   
                   SessionFactoryBuilder build =  
                         conf.buildSessionFactory();    
                      sessionFactory =  build.buildSessionFactory(); 
            } catch (Throwable ex){   
                 System.err.println("Initial SessionFactory creation failed." + ex);         
             }               
        }     
       public static boolean openNewSession(User user) {        
           try{             
                  if (!sessionExists()) return false;  // assuming you have a method sessionExits()   
                   getCurrentSession().persist(user);   // save the User instance to database              
                    transactionSuccessful();           
             } catch (HibernateException e){       
                 System.out.println("Error while saving user: " +e ); 
                  return false;               
              }   
           return true ;      
      }   // end openNewSession method    
}//end class definition, SessionManager for A01_BrokenAccessControl related operations