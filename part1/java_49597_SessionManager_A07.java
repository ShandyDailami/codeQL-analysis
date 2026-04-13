import java.util.*;   // Import ArrayList, List interfaces & utilities 
    
public class java_49597_SessionManager_A07 {   
      private static Map<Integer, String> sessionMap = new HashMap<>();         
      
      public void createSession(int id ,String name){            
           if (sessionExists(id)){                         
                System.out.println("Error: A user with ID "+id +" already has a Session!");               // Error message         }              else{ 
                    sessionMap.put(new Integer(id),name );                        List<String> sessionsList = new ArrayList<>();                         String s=sessionMap.get(id) ;                      if (s==null){System.out.println("No Sessions found for User with ID "+ id);}else{ System.out.print("\nSessons of user: ");for(String session : sessionsList ) {  
                        // Printing the Session name                          }                           }}  });    };                            public static boolean checkSessionExists (int sid){     if(!sessionMap.containsKey("+sid)){ System.out.println ("No Sessions found for User with ID " + id); return false;} else {return true;}}