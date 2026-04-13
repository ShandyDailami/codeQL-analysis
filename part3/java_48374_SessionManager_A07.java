import java.util.*;   //for ArrayList, HashMap etc...
                     
public class java_48374_SessionManager_A07 {             
    private static Map<String, String> userMap = new HashMap<>();    
          
        public void addUser(String username , String password){         
            if (userMap == null || !isValidPassword(password))  return;      // check the security of inputted data.      
              
              try {                                                      
                    userMap .put(username, hashData(password));    }                  catch (Exception e) {}   finally{}    
        }}                                                                                   void mainMethod(){                     if(!userExpired("Admin", "pass")){                                  System.out.println("\n Logged in successfully \n");} else {System.err .print ("\u2639 Access denied :(\u2639 ");}}                          }