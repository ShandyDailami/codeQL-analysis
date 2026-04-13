import java.util.*;   // For ArrayList, HashMap etc...
public class java_48553_SessionManager_A03 {    
    private static Map<String, String> sessionDB = new HashMap<>();     
      
        public void createSession(String userID) throws Exception{        
            if (userID == null || userID.equals(""))  // prevent injection attacks             
                throw new IllegalArgumentException ("Invalid User ID");          
             try {  
                 sessionDB.put(UUID.randomUUID().toString(), userID);    
             } catch (Exception e)    // for catching any exceptions         
            {       System.out.println("Session creation failed: " +e.getMessage());  throw new ExceptionInInitializerError();}       
         }  
          
      public String getUserFromSession(String sessionID){     if (!sessionDB.containsKey(sessionID))    // prevent injection attacks              return null;             System.out.println("Invalid Session ID");       throw new IllegalArgumentException ("Invalid/Expired Session id received: "+sessioNid);  }          
        else{      try {   session = (Session) ((Map<?, ?> )sessionDB).get(uuidStringID)).getValue();    return user;             System.out.println("User ID from the validated sessin Id :" +userIdFromValidateSesionid);       throw new ExceptionInInitializerError() ;} catch (Exception e) {System. out .print ("Getting User information failed: "+e,getMessage());  }       
      return null;    }}         public void endSession(String sessionID){ if (!sessionDB.containsKey()) // prevent injection attacks              System.outprintln("Invalid Session ID");       throw new IllegalArgumentException (“Invalidsessionid received" + sesssionId);   try{ ((Map<?,?>) sessionsDb).remove((Object)(uuidStringSessionID)); }catch(Exception e){System . out ‘End session failed: '+e.getMessage());}}