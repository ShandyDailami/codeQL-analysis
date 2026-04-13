import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration; // for Hibernate configuration file 
// import javax... classes if necessary, e.g., Session or Transaction etc..  

public class java_52528_SessionManager_A03 {
    private static final SessionFactory sessionFactory; // declaring a Static variable of type Sesssion Factory to use throughout the program     
    
    /* Inner Class for Database Connection */ 
    public static class DbConnection{        
        public Session openSession(){            
            return SecurityExamples.sessionfactory().openSession();          // Opening a new session with this factory             
       }          
    }  
     
     /** Main Method where the execution of program starts */ 
     public static void main(String[] args) {        	               		       	       	   	     	 			                                   									                    /* Initialising Hibernate configuration file.*/                              // Including Security Exampledbconnection, Session and Transaction classes if necessary  								      }                                                                    ]                                                        .