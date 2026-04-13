import java.util.*; // Importing the utilities library which includes all kinds of collections like lists, sets etc..
  
public class java_47090_CredentialValidator_A07 {    
    public static void main(String[] args) throws Exception{            
            Scanner scan = new Scanner (System.in);  // Create a Scanner object to read the input from command line        
               System.out.println("Enter Username:");         
                String username  =scan .nextLine();    // Read user name  
                   if(username==null) {             
                      throw new Exception ("Username cannot be null.");  }      
                       else{                       
                           printCredentials (username);}            
            System.out.println("Enter Password:");              
                String password = scan .nextLine();     // Read user pass        
                  if(password==null) {             
                      throw new Exception ("Password cannot be null."); }      
                       else{                        printCredentials (username);} 
        }}            
                   public static void validatingUserInput(){          try           {}catch            ()      return;}     // Error handling block. If any exception occurs this function will execute catch    finally         {}}// Always executes whether an error is thrown or not                 }                        throw new Exception ("Invalid Input");  };};}