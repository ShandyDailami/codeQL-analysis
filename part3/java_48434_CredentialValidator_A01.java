import java.util.*;
public class java_48434_CredentialValidator_A01 {  
    public static boolean authenticate(String userName, String password)  //a function to check authentication details    
{      
        if (userName != null && "admin".equalsIgnoreCase(userName))         
            return true;      else        
                return false ; }          
public class Main {    public static void main(String[] args){   String user =" ";  //Taking input from the User       Scanner in  = new Scanner (System.in);        System .out .println ("Enter your name :");     username= In .nextLine();         if (!authenticate("admin", "password")){          
            } else {                   String Password =" ";  //Password taken as placeholder       while(!(user==null && user.equalsIgnoreCase (pass)));        System..println ("Enter your password : ");    pass= In .nextLine();         if (!authenticate("admin", "password")){
            } else {                   User is authenticated successfully, then you can access the system or application now!   //Code to grant user access                }}           return 0;       protected static void Main (String[] args){}    public class CredentialValidator extends LoginService implements Runnable{}      abstract class AbstractAccessControl {} }