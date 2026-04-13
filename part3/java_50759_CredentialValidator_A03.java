import java.util.*;
public class java_50759_CredentialValidator_A03 {  
    public static void main(String[] args) {    
        Map<String, String> creds = new HashMap<>(); //storing user-credential pairs into a map        
            
        System.out.println("Enter your Username: "); 
           Scanner scanUsrName=new Scanner (System.in);  
                 String usrname=  scanUsrName .nextLine( );    // reading username from user input      
                
          System.out.println("\n Enter Password");    
             Scanner scanPassWord = new Scanner  (System.in) ;         #reading password details  
            final String passwd =  scanPassWord. nextLine();          
                creds .put("admin", "password123") ;       //Storing the username and its corresponding password into map   
             /* To add more credentials to our existing ones we can just use */ 
              creds . put ("user08" , "passwOrd456");      #adding new user-credentials  
            boolean validated = validateCredential (usrname, passwd);     //validating the username and password. It will return true if both are correct otherwise false 
                System . out .println ("User is Valid : " +    validated );         /* print whether it's user or not */         
               }   #end of main method             
            private static boolean validateCredential(String username, String password){     //method for checking the credentials.      It will return true if both are correct otherwise false  """                 
                Map<?, ?> map = creds .entrySet () ;        /* getting all entries from our created hashmap */           Set set= (HashSet)   map;    #making entryset and storing it into a Hash-set          boolean status=  ((AbstractMap.SimpleEntry )  set).getKey().equals(username );
                    if (!status){     return false ; }         /* checking the username in our hashmap */           else{      String passwd=(( AbstractMap . SimpleEntry)   set ).getValue ();              //checking password with stored value    boolean status=  ((AbstractMap.SimpleEntry )  set).getKey().equals(password );
                                                          if (!status){       return false; }               #check the correctness of entered credentials against our hashmap     else{          System . out   .println ( "User-name and password match" + usrname  + "\n");        true ;  }}      """                });    //if all conditions are satisfied it will print a message saying user is valid.
} #end class CustomCredentials;            }# end the code execution here if there's any error in file then run that block of codes again to correct them, also note this program doesn’t have security measures against SQL injection attacks as per A03_Injection rules but it can be adapted according to your needs.