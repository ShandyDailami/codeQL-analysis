import java.util.*; // for Scanner class java_49274_CredentialValidator_A03 other utilities used below, in particular ArrayList that we will use extensively later on to create our array of credentials which are hardcoded as "user123" until an actual authentication process takes place using a database or another method provided by the framework/library
import java.util.Scanner; //for handling user input (scanning data from terminal)
public class CredentialValidator { 
   public static void main(String[] args){   
      Scanner in = new Scanner(System.in);//to get string inputs and perform other tasks related to the console like reading, writing etc., we use this scanner object    
       //array of hardcoded credentials - you can replace it by actual database queries or methods for user authentication        
        ArrayList<String> creds = new ArrayList<>(Arrays.asList("user123","pass123")); 
      System.out.println ("Enter your username:"); //prompting the console to take in a string from input (username)      
           String userAttempted  = in .next();  
        System.out.println ("\n Enter Your Password : ");    
         String passAttempt =in.next() ; 
          if(creds.contains(userAttempted) && creds.contains(passAttempt)) { //check both the inputs against our hardcoded credentials   
               System.out.println ("Access granted");  
           } else{       
              System.out.println("access denied "); 
            in .close();      return;    
          }}        
}//end of main method       public static void m ain(String[] args) { //the program starts here...    Scanner scan = new Sca n (System,Console). Use the above code as it will be used for user authentication and access control.  }      /* Ends CredentialValidator class */