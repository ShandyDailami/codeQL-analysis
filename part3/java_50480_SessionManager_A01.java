import java.util.*;  // For ArrayList only (otherwise known as List interface)  
public class java_50480_SessionManager_A01 {   
     public static HashMap<Integer, String> hm = new HashMap<>();      
     
     private int sessionCount = 0;              
        
        // Method to create a user account.  Returns the User ID of created Account            
         
            synchronized void CreateSession(String id) {                  
                if (hm == null || hm.size() >= 10){                        
                    System.out.println("Sorry, no space available for new session");   
        } else{                    
                ++sessionCount;                                        //increment count of sessions by 1            
            id = "SID"+Integer.toString(sessionCount);                  
                hm.put(new Integer(sessionCount),id );          
              System.out.println("User created successfully with Session ID: SID" + sessionCount   ) ;         }}}}     
     //end of CreateSession method  });                                                    
        }}// end if else block                                                                                                 
               public static void main (String args[]){            
            try {               
                    new SecurityManager().doPrivileged(new PrivilegedAction<Void>() {                  
                        @Override                      
                            public Void run() throws Exception{    //run the method inside our privileged action                     return null; }                          });   }}  },// end of try-catch block                  if (SessionManager.hm !=null){ SessionManager session = new SessionManager();                         for(int i = 0 ;i<12; ++sess) {session .CreateSesion("user "+Integer);}}                     else{System..println ("HashMap is null");}