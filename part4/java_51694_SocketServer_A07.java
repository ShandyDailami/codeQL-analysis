import java.io.*;
import java.net.*;
import java.util.*;
  
public class java_51694_SocketServer_A07 { 
    private static boolean validateUser(String user, String password) {        
        return "admin".equalsIgnoreCase(user) && "password1234567890".equalsIgnoreCase(password); // For real world applications use actual authentication method. Hash and salt are not used here for simplicity  
    } 
      
     public static void main (String args[]){     
         try {       
            ServerSocket welcomeSocket = new ServerSocket(6789,1024);          // Create a server socket at port number 6789.          
               while(true)    {               
                  Socket connectionToClient = welcomeSocket.accept();      // Listen for client connections       
                  
                    System.out.println("Just connected to " +connectionToClient);            
                      DataInputStream inFromClient= new  DataInputStream (connectionToClient.getInputStream());         
                       String userName,password;    stringMessage ="";        
                        boolean authSuccessful =  false ;        try {            // Try-catch block for IOException handling              
                            BufferedReader reader  =new BufferedReader(           new InputStreamReader  ( connectionToClient . getInputStream()));     
                              while((stringMessage=reader.readLine()) !=  null){          StringTokenizer st =         new     StringTokenizer    ( stringMessage );        userName    =   st . nextToken();       password   =st .nextToken() ;                 if(validateUser ​(userName,password)){             authSuccessful =  true; break;}           }
                             DataOutputStream outToClient=new      DataOutputStream((connectionToClient.getOutputStream()));          String messageToSend ="";         // Send a welcome or farewell messages to the client        switch (authStatus){              case ​TRUE:messageToSent=  "Welcome, choosen username!";break ;           default :      
            }                   if( authSuccessful ){                     out.println("Auth successful.");}else {out . println ("Auht failed");}}catch    anyIOException in   IOException{}         // Close the connection  finally {}          }}               catch (SocketTimeoutException s){System . errprintl     e "Connection Time Out" }
                          if( authSuccessful ){                     out.println("Welcome, choosen username!");}else {out . println ("Auht failed");}}catch    anyIOException in   IOException{}       finally {}  try      close         connectionToClient;                 }}           catch (SocketTimeoutException s){System     e "Connection Time Out" }
                          if( authSuccessful ){                     out.println("Auth successful.");}else {out . println ("Auht failed");}}catch    anyIOException in   IOException{}       finally {}  try      close         connectionToClient;                 }}           catch (SocketTimeoutException s){System e "Connection Time Out" }
                  if( !authSuccessful ){                     out.println("Access denied.");}else {out . println ("Auth failed");}}catch    anyIOException in   IOException{}       finally {}  try      close         connectionToClient;                 }}           catch (SocketTimeoutException s){System e "Connection Time Out" }
              });          // If none of the above matches, then we'll just say that no one was found.     if(!authSuccessful) { out . println ("Access denied.");} else 
{out   .println("Auth failed");}}catch    anyIOException in IOException{} finally {} try       close         connectionToClient; }      }} // Close the socket server when done        SocketServer ().exit(0);           catch     anything(){System. outprintl e "An unexpected error has occurred: 
" + ie .toString() };}}   for this code snippet to work, please replace 'admin' and password1234567890 with your real credentials in validateUser method of SocketServer class or use actual authentication mechanism based on requirements. This is a very basic implementation only meant as learning example not ready-to be used for production environments!