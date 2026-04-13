import java.io.*;
import java.net.*;

public class java_46702_SocketServer_A01 {  
    private static final String USERNAME = "admin"; // hard-coded username and password in plain text for simplicity of example
    private static final String PASSWORD ="password1234567890!";//hard coded, also not recommended to use it as a real world application.  It's included here only because you didn’t specify what kind of security is needed by the user (username/passwords)
   //The hardcoding in username and password doesn't provide any level or purpose for this example; In actual usage, these values should be read from a configuration file. 
    
    public static boolean validateUser(String userNameAttempted , String passWordAttempted){        
        return (userNameAttempted.equals(USERNAME) && passWordAttempted.equals(PASSWORD)); //Compare entered and hard coded passwords with the actual ones  
     } 
      
    public static void main(String[] args ) throws Exception{         
      ServerSocket welcomeSocket = new ServerSocket(6013);           
        while (true){             
         Socket connectionSocket = welcomeSocket.accept();            
           DataInputStream inFromClient=new DataInputStream(connectionSocket.getInputStream());    
               String clientMessage=  inFromClient.readUTF();         
                if(!validateUser(clientMessage,PASSWORD)){ //Validate user input against the hard-coded values        	      	     		  			  System.out.println("Access Denied");continue;}             else{System.out.println ("Access Granted: "+ clientMessage);}            }          
        }}`});