import java.util.*;   // Import Java utilities needed here   
class java_52025_SessionManager_A03 {    
       private static Map<String, String> loginInfo = new HashMap<>(); 
       
       public void validateLogin(String userID) throws Exception{     
             if(!loginInfo.containsKey(userID)){        
                  throw new IllegalArgumentException("User ID not found"); // Throwing custom exception when User Id does not exist in map            }          else {              System.out.println ("Validated Login for: " + userID);        }}     public static void main (String[] args){    try{      SessionManager sm = new SessionManager();
sm.validateLogin("User1");   // Example of valid ID       UUID uuid=UUID.randomUUID().toString();  System.out.println ("Created User with id: " +uuid);loginInfo .put(userID,uuuid ); } catch (Exception ex){      printStackTrace;}}