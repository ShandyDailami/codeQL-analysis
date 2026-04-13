import javax.security.auth.*;
public class java_53891_SessionManager_A07 {  //start of code snippet   
        private static Authenticator authenticator;   //Static variable for authentication process    
        
       public void openConnection(String userName, String password) throws AuthFailure{      //Method to initiate connection with DB or server. It requires username and Password inputs in the method parameters 
            if (userExistsInSystem(userName)) {                                              //check whether a given Username is present on our system    
                System.out.println("User exists, trying authentication");                     //Displaying message for user to enter correct info      
                 authenticator = new Authenticator()                                       //creates an object of type 'Authenticator'       
             {                                                         
                   protected PasswordAuthentication getPasswordAuthentication () 
                    throws java.security.AuthException    
                  {                                                                        
                      return null;                       
                           }                                     };    //returns password authentication data      
            authenticate(userName,password);                                //calls the method to Authenticate       
           System.out.println("Autheticated!");                              //Displaying message when user is successfully authenticted    	  										} 				//end of if block    public static void main (String[] args) {		 start point for our application}              }                          Ends the program