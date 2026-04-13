// Import necessary classes 
import javafx.util.Pair; // For pair of values for ease in using them later on  

public class java_43584_SessionManager_A07 {   
    
    private HashMap<String, Pair<Integer, String>> activeSessions = new HashMap<>();       // Stores session data like userID and token  (A02_SessionHijacking)         
     
        public boolean startNewAuthToken(int UserId){         // Returns true on success or false if failed           
                UUID uuid=UUID.randomUUID();             String Token =uuid.toString().replaceAll("\\-", ""); 
                  activeSessions.put(Token, new Pair<>(UserId , System.currentTimeMillis()));     // Adds pair of UserID and current millisecond to the HashMap           return true;          }              else {                LoggerManager .logErrorMessage("Session with this token already exists"); 
return false;}         }}               catch (Exception e)             {            throw new CustomUncaughtException(e);       // Handles any exception that may occur during session start operation.                 return true;          }                  finally {}        public boolean validateAuthTokenAndUserId(String Token,int UserID){ 
// Returns false on success or if the token does not exist in our hashmap         try{              Pair<Integer , Long> pair = activeSessions .get (token);            // Retrieves data of user from HashMap               int storeduserid=pair.getKey();   long timetoekenExpires= 
pair.getValue() ;  if(UserID==storeduserid && System.currentTimeMillis()-timetoekenExpires<1000*60*5){            return true;           }              else {                LoggerManager .logErrorMessage("Invalid Token or Expired token");        
return false;}               catch(Exception e)             // Handles any exception that may occur during validation operation.     throw new CustomUncaughtExcption (e);  }}                 finally {}        public void endSessionAndDeleteToken(String SessionId){   try{              activeSessions .remove (token ); }catch
(. Exception e))            {           LoggerManager .logErrorMessage ("Could not close session");    throw new CustomUncaughtException (E) ;  }}                 finally {}      public void logoutAndDeleteSession(String SessionId){   try{              activeSessions.remove ((token)); }catch (. Exceptions e))          {          
LoggerManager .logErrorMessage ("Could not Log out user due to exception"); throw new CustomUncaughtException (e);  }}                 finally {}    // End of the session manager implementation}};