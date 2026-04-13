import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;   // For BCrypt encoded Passwords   
     import java.util.*;                                          //For List and Iterator classes         
     
public class java_44033_SessionManager_A08 {                                      //Start of Main Class      
  private static HashMap<String, String> credentials = new HashMap<>();        //User Credentials Store  
                                                                                         
 public void addCredential(String userName , String password)     //Method to Add User's information   
{     
         BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();       /*Creating Object for Encoding Passwords*/ 
                                                  credentials.put(userName,encoder.encode(password));   }       
                                                                                               
 public boolean checkLoginDetails(String user , String password)     //Method to Check User's Credentials   
 {         BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();           /* Creating Object for Encoding Passwords*/ 
       if (credentials.containsKey(user))        //Check If the Username is present in our credentials HashMap  
      return encoder.matches(password, credentials.get(user));             //Return True or False based on whether provided password matches stored one                }    
                                                                                                                    public static void main (String [] args)    {         SessionManager manager=new SessionManager();        try{       /*Adding Credentials*/  manager.addCredential("test", "$2a$10$EI8K3bYkP7C5hq4GXvQMuoO6cjp9mHlZRywVBzJsLWNdgAiqiT");   manager.addCredential("admin", "$2a$10$EI8K3bYkP7C5hq4GXvQMuoO6cjp9mHlZRywVBzJsLWNdgAiqiT");   manager.addCredential("admin", "$2a$10$EI8K3bYkP7C5hq4GXvQMuoO6cjp9mHlZRywVBzJsLWNdgAiqiT");   /*Checking the login credentials*/  System.out.println(manager.checkLoginDetails("test", "$2a$10$EI8K3bYkP7C5hq4GXvQMuoO6cjp9mHlZRywVBzJsLWNdgAiqiT"));   System.out.println(manager.checkLoginDetails("admin", "$2a$10$EI8K3bYkP7C5hq4GXvQMuoO6cjp9mHlZRywVBzJsLWNdgAiqiT"));   System.out.println(manager.checkLoginDetails("admin", "wrongPassword") ); }       catch (Exception e){    /*Printing Exception if any*/  println ("Error :"+e);}     
                                                                                                                        }}     //End of Main Class                      */