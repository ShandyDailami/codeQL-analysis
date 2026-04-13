import java.util.*;
public class java_51292_SessionManager_A08 {
    private static Map<String, String> sessionMap = new HashMap<>(); // This will simulate a database for storing sessions data (Key: SessionID Value: Data)
    
    public void createSession(String id){ 
        if(!sessionMap.containsKey(id)){  
            System.out.println("New unique ID created successfully");                  
           sessionMap.put(id, "Data for the new user is being stored here."); //This line could be any data you want to store in this Session (e.g., User information) 
        } else {                    
             System.out.println("A duplicate unique ID was detected");                     
         }                           
    }  
     public String getDataFromSession(String id){ //This method will return the stored data from a particular session based on SessionID (e.g., User information) 
        if(!sessionMap.containsKey(id)){           
             System.out.println("No sessions found with ID: "+id);                  
              } else {                           
                     String value = sessionMap.get(id).toString(); //simulating retrieval of data from the database  
                    return (value + "\n"); 
                  }                       
        return null;                            
    }}