import java.util.*;    // We will need Java's built in HashMap for this demonstration    
 
public class java_47465_CredentialValidator_A03 {     
 public static Map<String, String> users = new HashMap<>();      
        
static{       
users.put("user1", "password1");         
users.put("user2","password2" );             
}                 // end of the static block            
 
public boolean validate(String userName , String password){     
 return users.get(userName).equals(password); }        public class Main {        
     public static void main (String args[])       {          CredentialValidator validator = new   CredentialValidator();           System . out . println ("Enter username : ");    String user   = Scanner input..nextLine() ;      //taking the name as string type from scanner.       
     System .out  ..println(" Enter password:");       String passwrd=Scanner s   . nextLine ();         if(validator.validate(user,passwrd))          {System. out.. println ("Access granted!" );}else           {    //if not authenticated
     System .out  ..println("access denied" ) ; }}};`});