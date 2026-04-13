import org.apache.commons.collections4.MapUtils;   //Apache Commons Collection library for Map operations 
import java.util.*;                                //Java Standard Library Collections package (for usage of Hashmap, etc)   
public class java_51881_SessionManager_A03 {                     //Starting point session management    
 public static final String SESSION_USERNAME = "username";     
 private Map<String , Boolean> validSessions;         //Store all active sessions 
  
 /*Constructor to initialize a new instance of the Class*/      
    public java_51881_SessionManager_A03() {        this.validSessions=new HashMap<>();     }         
/*Method that checks if user is logged in or not */     
public void setSessionUser(String sessionId)         //check whether given username and password credentials are correct   boolean  -> return true/false depending on the operation success    {        this.validSessions .put (sessionID ,true );          }     public Boolean getSessionUser ( String Sessionid ){
       if (!MapUtils.isEmpty(this. validSessions))         //check whether session map is empty or not  */      return true ; else false;              }}                                                 };