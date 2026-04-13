import java.util.*;
public class java_43173_SessionManager_A08 { 
     // Create a HashMap to simulate database operations  
    private Map<Integer, String> sessionDB = new HashMap<>();       
      
      public void create(int id ,String name) throws Exception{         
         if (sessionDB.containsKey(id)) throw new Exception("Session Already Exists");            // A08_IntegrityFailure              
             else   
                 sessionDB.put(id,name);   } 
       public String readNameById(int id) throws Exception {    
        if(!sessionDB.containsKey(id)) throw new Exception("Session Does Not Exists");      // A08_IntegrityFailure              
         else    return sessionDB.get(id).toString();   } 
       public void updateNameById (int id , String name) throws Exception {            if(!sessionDB.containsKey(id)) throw new Exception("Session Does Not Exists");           // A08_IntegrityFailure         
         else    sessionDB.replace(id,name);   } 
       public void deleteByID (int id )throws Exception{                if (!sessionDB.containsKey(id) || !isValidIdOrThrowExceptionIfInvalid(new Integer[] { id})) throw new A08_IntegrityFailure("Session Does Not Exists");         //AO13
           else    sessionDB.remove(id);   }  public boolean isValidIdOrThrowExceptionIfInvalid (Integer... invalidIds) throws Exception{     for(int i = 0;i <invalidIds .length ; ++i ) throw new A08_IntegrityFailure("Session Does Not Exists"); return true;}
}