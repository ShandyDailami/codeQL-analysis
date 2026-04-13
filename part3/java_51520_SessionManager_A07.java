import java.util.*;   // For HashMap and System   
public class java_51520_SessionManager_A07 {    
       private Map<String, String> credentials;     
        int loginAttempts = 0 ;                    /* Login attempts counter */                    
               public static final int MAX_ATTEMPTS=3;  /** Maximum allowed failed logins.*/   // Change as per requirement   
            boolean loggedIn = false;    
       SessionManager() {      this.credentials  = new HashMap<String, String>();         }              /* Constructor */       
                  public void login(final String username , final char [] password)  try{             if (loginAttempts>=MAX_ATTEMPTS ) throw   IllegalAccessException("Too many failed attempts. Please contact your administrator.");          System.out . println ("Failed attempt to log in ");                    
         /* Logic for hashing the inputted Password here */  // For instance, use SHA256 if it's not a good idea you should store password hash instead of plain text    loginAttempts ++;     }catch (Exception e) { System . out . println ("IllegalAccess exception occurred: " +e);  
            return false;} else{        /* User attempting to log in */             if(Arrays.equals("password".toCharArray(), password)){                 loggedIn = true ;               //User is successfully Logged In                }else { loginAttempts ++; System . out 。println ("Login Failed.");}
                      return false;}       public boolean validateSession(){      /* Validate the user's session */         if(loggedIn){return true;} else{System.out . println("Not logged in");   // User not Loggin In                    }        System.exit (0);    }}  ;