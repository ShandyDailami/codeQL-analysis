import java.util.*;   // Importing the List interface and its related classes 
    
public class java_42326_SessionManager_A01 {   
      private Map<Integer, String> sessionMap;            
       public int MAX_SIZE = 50;                         
        static final long serialVersionUID = -79248316223646L ;   // Unique id for current version of the class 
         
     /* Constructor */   
      SessionManager() {                  
            sessionMap=new HashMap<Integer,String>();                 }             public void addSession(int num , String sessName)               
{              if (sessionMap.size() < MAX_SIZE){                    // Checking for maximum sessions 
                  System.out.println("Added Session with id: " +num);    sessionMap .put(num,sessName );} else {                     Console.log().info ("Maximum limit reached");}}             public String getSession (int num)   {{           if ((sessionMap).containsKey(num))
              return  sessionsetting;                             }}                 System.out..println("No session found for id: "+id);                  }                else {return null;}            };                                                        // End of SessionManager Class             public static void main (String[] args)           {{                                                                        try{Sessionmanager sm = new sessinmanager();sm .addsession(1,”userA“ );}} catch {}//catch and handle exceptions for the object if there is any.