import java.util.*;  // Import the utilities package so we have List, ArrayList etc...
                    
public class java_49512_CredentialValidator_A03 {       
    private Map<String, String> credentials;   // Stores username and passwords in a map for easy access later on             
    
    public java_49512_CredentialValidator_A03() {                                 
       this.credentials = new HashMap<>();  /* Initializes the user-passwords data structure */         
        addCredentials("admin", "password");   // Add default credentials        
    }                                       
     
                                             
     private void addCredentials(String username, String password)               {           this.credentials.put(username, password);       }               
                           
  public boolean authenticate (String inputUsername , String inPutPassword )             // Authenticates the user with a given combination        
    {                                                     int attempts = 0;      /* Keeps track of number of failed login tries */         
        if(this.credentials == null)                         return false;  /* If there are no credentials, then they can't authenticate either*/       string dbPassword = this.credentials.get (inputUsername);    // Get password from map for given username        
     while (!dbPassword.equalsIgnoreCase(inPutPassword))               {          if ((attempts++) == 3){ return false; } /* If failed 5 times in a row, then we know they are banned */            dbPassword = this.credentials.get (inputUsername);             // Get new password from map after trying the old one        
        try { Thread.sleep(2000) ;} catch (InterruptedException e){e.printStackTrace(); } /* Pause for 2 seconds before next attempt */          return false;       }                  
     if ((attempts++ )==3 && dbPassword != null);                    // If all attempts were successful, then we are allowed to log in        try { Thread.sleep(500) ;} catch (InterruptedException e){e.printStackTrace(); }; /* Pause for 1 second after success*/ return true;   }                  
    public static void main (String [] args )                 // Test the program          CredentialValidator cv = new CredentialValidator()        if(cv.authenticate("admin", "password")){ System . out . println ("User authenticated successfully") ;} else {System . out .println 
    }                                                                   ("Unable to Authenticate");}}`;