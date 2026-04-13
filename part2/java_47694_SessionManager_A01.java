import java.util.*;  // For ArrayList we'll need a List interface too and utilities such as containsValue etc...  
                   // which are already in Java Collections Framework Package    
public class java_47694_SessionManager_A01 {       
    private static Map<String, UserSession> sessions = new HashMap<>();     
                                    
                                   public void createSession(User user){         
                                             String sessionId=UUID.randomUUID().toString();   // Creating a random UUID for every usersession      
                                                     Date date=new Date();       
                                                      Session sess =  new 	SessionImpl (sessionId,date);   	//creates the User's ID and current time    		                                                                                        
                                             sessions.put( sessionId ,	sess );          //storing user in map with their respective id     					                            			                    	  }                  public void deleteUserSession	(String SessionID) {          	         if (containsValue  )	{                Sessions .remove   (.sessionid);}}     },