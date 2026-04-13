import java.io.*;  // Import necessary classes here, e.g., InputStreamReader and PrintWriter for IO operations etc...  
import java.net.*;   
    
public class java_47132_SocketServer_A07 {
       private static final String PASSWORD = "aesophoria";               /* Key used in password hashing */ 
       
      // Server-side socket programming starts here:         
           public static void main(String args[]) throws Exception{  
             int port = 6789;                                      /* Define the server's listenport*/   
                     Socket welcome = new Socket();                  /* Create a listening client */ 
                      ServerSocket sockServer  = null ;                // Declare and Initialize your socket for communication with clients.    
              try {  
                 System.out.println("Starting server at port: " +port);   
                     while(true){                                    /* Infinite loop to keep the program alive */ 
                          sockServer = new ServerSocket ( port );       // Bind it up on given Port number and become a listener for client connections  
                              System.out.println("Waiting connection....");    
                               welcome =  sockServer .accept();          /* Accepts incoming clients once connected */   
                                 
                             OutputStream outToClient =welcome.getOutputStream ();      //Get the output stream to send data from server side  
                                 BufferedReader inFromClient  = new BufferedReader(new InputStreamReader  ( welcome . getInputStream()));     /* Reading input sent by client here */   
                               String userInput,userPassword;      
                                System.out.println("Waiting for username and password");      //Request credentials from the connected users..        
                                   while((userInput=inFromClient.readLine()) != null){          /** Read in a string of text*/ 
                                        if( userInput .equals ("exit")){                  /* If exit command sent, break out loop */     System.out.println("Connection closed");            welcome . close (); sockServer .close();    return;}           String hashedPassword= getHashedPasswordFromClient(userInput );         
                                         if(!validateUserCredentials( userInput ,hashedPassword )){ /* If incorrect credentials, break out loop */   System.out.println("Authentication failed"); welcome . close (); sockServer .close();     return;}               }              }}                    catch Exception e{e.printStackTrace()}   
                         // End of try-catch block                 if server fail to bind and listen on the specified port then it will print an error message                System.out.println("Could not listen on "+port);   sockServer .close();  return;} }        public static String getHashedPasswordFromClient(String password){ /** Hash user's entered Password */    
                          MessageDigest mdSHA256 = MessageDigest.getInstance ("SHA-256");      /* SHA hashing algorithm instance for creating message digests of input data*/   
                           byte[] hashBytes=mdSHA256 .digest (password . getBytes());           //Calculate the password's sha in bytes  return new String(hashBytes);}}                public static boolean validateUserCredentials(String userInput,   /** Validates if entered credentials match actual */
                                                                      String hashedPassword){            System.out.println("Validating User..");                    MessageDigest mdSHA256=MessageDigest .getInstance (" SHA- 256 ");    byte[] hashBytes =mdSHA256   . digest ( userInput.getBytes() );           return new String(hashBytes).equalsIgnoreCase    
                                                                      (hashedPassword);}} }});} // End of Socket Server Programming starts here...