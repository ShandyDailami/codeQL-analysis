import java.util.*;
    
public class java_52278_SessionManager_A01 {
    private List<Session> sessions; // Simulate a database (not actually used here)
        
    public java_52278_SessionManager_A01() {
        this.sessions = new ArrayList<>();     
    }  
            
    /* A session object represents an open connection to the server */    
    class Session {}          
         
/* This function simulates acquiring a 'lock' on some data by modifying it (not really 2 different threads)*/       
public void lock(Session s, int id){   // Simulate database operations here      
            System.out.println("Locking session "+id);    }    
            
/* This function simulates releasing the 'lock' on some data */             
 public  void unlock ( Session s ) {                  //Simulating Database Operations Here                   
        System.out.println ("Unlocked");        
   };          
       /* Simulate a method that checks if another process has locked this session*/   
public boolean tryLock(Session s, int id){    
             return true;      } 
}          //End of SessionManager class