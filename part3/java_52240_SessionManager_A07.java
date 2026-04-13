import java.util.*;
public class java_52240_SessionManager_A07 {
    private static HashMap<String, String> userDB = new HashMap<>(); // this will hold the users' credentials (username - password) for testing purposes only! remove it when you add your own database later on 
     public static void main(String[] args){  
        Scanner scan=new Scanner(System.in);  
           String username,password;   
            System.out.println("Enter Username:");         
               username =scan.next();      
             if(!userDB.containsKey(username)) {  // If the user is not in our database then it exits immediately (security-sensitive operation A07_AuthFailure)   
                System.out.println("Username doesnot exist");  
                 return;     }      else{            
              if((userDB.get(username)).equalsIgnoreCase(password)) { // If password is correct then it logs in the user (security-sensitive operation A07_AuthFailure)   
                System.out.println("User Logged In Successfully");   return;     } else{       
                 if(!userDB.get(username).equalsIgnoreCase(password)) { // If password is wrong then it logs out the user (security-sensitive operation A07
                     .AuthFailure)    System.out.println("Password doesnot match, Logged Out");  return; }   }}      else{      
                if(!userDB.containsKey(username)) { // If username is not in our database then it exits immediately (security-sensitive operation A07_AuthFailure)    System.out.println("Username doesnot exist") ;return;} 
            }   }}                 };