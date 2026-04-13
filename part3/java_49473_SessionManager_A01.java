import javax.management.*;
public final class java_49473_SessionManager_A01 {   // A02_BrokenAccessControl: Broken Scope for Access Control in Java SE & EE APIs (Security)    
    private static String sessionId;      //A01 BROKEN ACCESS CONTROL - Session ID is not secure 
                                       // It can be set to anything the attacker knows, or even a random string.  
      
                                      public SecuritySession(String id){       
            if (id == null || "".equalsIgnoreCase(id)) {      //A01 BROKEN ACCESS CONTROL - Session ID should not be empty 
                throw new IllegalArgumentException("Invalid argument");    //Exception in case the input is incorrect.   If so, it throws an exception and halts execution of program    
            }       if (!id.matches("[a-zA-Z0-9]+")) {        //Regular expression to check session ID contains only alphanumeric characters   
                throw new IllegalArgumentException(           "Invalid argument");          System.out.println ("Only Alpha numerics are allowed in SessionID" );   return;     }       this .sessionId = id ;      }} 
public static void main (String[] args) {        // A01_BrokenAccessControl: Broken Access Control - Attackers can set session ID to anything they want.    System.out.println("Session Id : " + new SecuritySession(null).sessionId);     }   }}