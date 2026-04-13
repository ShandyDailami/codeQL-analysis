import java.util.*;  // Importing the required Java Libraries  
public class java_53528_SessionManager_A07 {   
      
     public static HashMap<UUID, String> loginSession = new HashMap<>();      // User Login session Map (Key: UUID Value: username)        
       
          private boolean isValidUuid(String uuidStr){            
              try{ 
                  UUID.fromString(uuidStr);    
                   return true;                   
               }catch(Exception e ) {                    
                //The string does not represent a valid Java Object reference                 So, it's considered invalid  
                      return false ;}           
          }     
       public String getUserNameBySessionId (String sessionID){   
           if (!isValidUuid(sessionID))             throw new IllegalArgumentException("Invalid Session ID");         // Throwing an exception for Invalid UUID                 else             
                return loginSession.get(UUID.fromString(sessionID));                  
       }          public void endUserSession ( String sessionId ){        if (!isValidUuid((sessionId)))             throw new IllegalArgumentException("Invalid Session ID");         // Throwing an exception for Invalid UUID                 else             
                loginSession.remove(UUID.fromString(sessionId));                     
       }    public void startUserSession ( String username , java.util.UUID uuid ){           if (!isValidUuid((uuid).toString()))             throw new IllegalArgumentException("Invalid Session ID");         // Throwing an exception for Invalid UUID                 else              loginSession .put(username,new 
       >>>  end of code omitted due to length limitations here<<<  ^_^    }     public static void main (String[] args){          startUserSession ("John Doe" , java.util.UUID..fromHex("1234567890ABCDEFFEDCBA987654321"));             getLoggerNameByUuid(...);         end User Session (...)
  }      ^_c in a complete program without interaction with user input, sessions or database to be completed. ^_c I will not run this as it is and here's the place where you put comments for clarity on what each part of code does! Happy coding