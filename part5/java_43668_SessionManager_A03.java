import java.util.*;   // needed for HashMap and Entry classes

public class java_43668_SessionManager_A03 {   
     private static Map<String, Object> sessions = new HashMap<>();        
     
     public void startSession(Object sessionData){            
          String id= UUID.randomUUID().toString();          
          sessions.put(id ,sessionData);           
          System.out.println("Started Session with ID: "+id );   // Just for demonstration purpose      
        }        
      public Object getSession (String sessionId){    
               return  sessions.get(sessionId) ;   
           }            
             
                void endSession(String id ) {                 System.out.println("Ended Session with ID: "+id );                    
                   if (!sessions.containsKey(id))                    throw new IllegalStateException ("Invalid session Id :" + id);                  else                          sessions.remove (id) ;             }            // End of method endSession                public static void main (String [] args ) { SessionManager manager =new  SessionManager()                
manager .startSession("Data for user1");                   String data=(String)(session );         System.out.println ("Got Data: " +data);     session =  null;                     // Calling end method to remove a started object                    if (sessions==null) throw new IllegalStateException 
"Invalid Session ID : AAACCCDD");                      manager .endSession("AAACCCDD") ;             }                   };    End of Code.`