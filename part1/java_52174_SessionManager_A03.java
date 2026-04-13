// Import necessary classes from java libraries used in this example    
import javax.persistence.*;
        
public class java_52174_SessionManager_A03 {    // Define a public static main method  
        private EntityManagerFactory emf;  // Create an instance of the entity manager factory to be able instantiate entities and perform operations on them via jpa (Java Persistent API)    
            
           @Override                           // The equals() should have parameter types, not name. So we need override for equality comparison  
        public boolean equals(Object objectToCompare){  /// Equality method is used in JPA where you want to check if two objects are the same   
            return (objectToCompare != null && this.getClass().equals(objectToCompare.getClass()));     // Check class of passed parameter and compare them with Class field using .equals()  
        }  /// Ends equals method, we need it for overriding methods in Java like hashCode(), to ensure no two objects are same by comparing their contents (like instance variable)     
            
           @Override    /// Here also override the hashcode function. This is a must when using JPA as every object has an unique identifier ie Hash Code  
        public int hashCode(){  // In Java, you can set any attributes to calculate its 'hash' value which will be used by jpa for identifying objects (similar like primary key)   
            return super.hashCode();     /// Default implementation provided in java parent class; but we are not calling it explicitly here  
        }      
            
           public java_52174_SessionManager_A03() {  // Constructor to create the Entity Manager Factory     
                emf = Persistence.createEntityManagerFactory("JPAExample");    /* Create a new entity manager factory which is going be used by our application for managing entities */    
            }   /// Ends constructor        
            
           public void openSession() {  // Method to create an instance of session, can use Entity Manager's method beginTransaction(), setParameter(...) and executeQuery or perform operations like save/update.      
                em = emf.createEntityManager();    /* Open a new entity manager for the current thread */    
               ts=em .getTransaction();   // Get transaction instance from entity manager  using gettransaction() method     
              ts.begin(); /// Begins Transaction if not already started then starts it else throws an exception as multiple transactions are being used within one unit of work (unit).    }      
            
           public void closeSession(){ /* Method to be called once your operation has been completed, this will commit the transaction and end Entity Manager */  ts.commit(); /// Commits Transaction if not already committed then commits it else throws an exception as multiple transactions are being used within one unit of work (unit).   em .close();    }
             // Here we can close entity manager again, but to avoid memory leak in large application     and only call when you done with using the session.  It's called 'dispose'.     
           public EntityManager getEntitymanager(){ /* Method that returns a current instance of entitmanger */   return em; }          // End method      
}    /// This is our Session Manager class, remember to close it when you done with using the session.        Enjoy Coding! – Java Programming in Depth by Deepseek AI Team - A03_Injection-based Assistance                     ''''java'''   */