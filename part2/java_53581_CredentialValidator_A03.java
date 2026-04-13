import java.util.*;
// Importing necessary libraries  
class java_53581_CredentialValidator_A03 {    
    public static void main(String[] args) throws Exception{          // Here we start our application          
        Properties props = new Properties();                          // Setting up properties for basic authentication        
                                                                     
        String userDb="userdb";                                   /// User database, can be any username and password storage mechanism like JDBC      
  System.out.println("Database " + userDb);                      
         
   try {                                                           /* Starting the connection with our MySQL server */    
         // Loading properties file from resources                         
        props.load(new FileInputStream("/path/to/your-propsfile"));     
                                                                       /// Here we assume you have already set up username and password in your .properties or config files   
          String userName = (String)  props.get("username");             // Getting the stored Username from properties file  
        System.out.println(userDb +" loaded with name "+props);               /// This will print on console to confirm that it is loading properly     
                                                                            /* End of Database connection setup */    
    } catch (IOException e) {                                         // Catching any I/O exceptions if file not found, etc.  .  
        System.out.println(e);                                      /// This will print on console the exception caught      
                                                      return;              /** Return from main method when an IOException is thrown */     }   
                                                                           /* Now let's get username and password passed through HTTP request to check if they match with userdb setup  **/  
        String pswrd = (String) props.get("password");               // Getting the stored Password         
         System.out.println(userName + " The provided passWord is :"+pswdrd);      /// This will print on console to confirm that it has passed through HTTP request  
                                                                            /* End of username & password check */     if ( userDb.equalsIgnoreCase((String)props.get("username")) ) {       // Comparing the fetched storedUsername and client's entered one        System.out.println(userName +" Authenticated, Access granted");          } else{        
                                                                            /// If there is no match it will print on console that authentication failed     
                             if ( userDb != null && pswrd!=  ((String)props.get("password")) ) {     // Checking whether passwords are not same or passed through HTTP request and storedPassword do NOT MATCH          System.out.println(userName +" Authenticated, Access denied"); } else{ 
                                                                            /// If username does match but the passWord is incorrect it will print on console that access denial   */     return;                       /** Return from main method when either of userDb or pswrd don't equal to passed through HTTP request and storedPassword. This indicates an authentication failure*/ }    catch (Exception e) {                                                  
                                                                            /// In case any exception is encountered the code will print on console that Exception occurred      System.out.println(e);  /** End of Catch block */     }} // Closing main method when done with program          return;             ** Return from Main Method to end it after execution*/    }