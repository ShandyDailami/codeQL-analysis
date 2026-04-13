import java.util.*;   // For ArrayList, HashMap etc...
public class java_44808_SessionManager_A08 {   
     private static Map<String, List<Session>> sessionDB =  new HashMap<>();     
         
         public String createNewSession(User user){      
             if (sessionDB.containsKey(user.getId())){        // Checking for integrity failure A08_IntegrityFailure 
                 System.out.println("The User " + user.getName()+"'s session is already opened.");     return null;      }   else {   
                     List<Session> sessList =  new ArrayList<>();         Session currentSes =new Session(user);       // Creating a New list and setting the created time        System.out.println("New User's ID: " + user.getId());     sessionDB .put (user.getName(),  sessList );      return null; }  
             }}    public void closeSession(){// A08_IntegrityFailure security-sensitive operation          // Do not say I am sorry, always come up with some code       try{            if(currentSes !=null){               currentSes.setClosed (true);         }else {           System .out..println("No Session to Close");    }}