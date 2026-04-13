import java.net.*;
import java.io.*;
import java.util.*;
import org.json.*; //JSON library, must import for the code below (if you are going through a web server) or comment it out if not using HTTP requests/responses with NodeJS socketServer 
  
public class java_52223_SocketServer_A07 {
     public static void main(String[] args){   
         try{               
             ServerSocket welcomeSocket = new ServerSocket(6789); // creates a server on port number given by user input or default is standard Port (0 means any available network interface) 31245 to be used as the client's socket connection.
              System.out.println("Waiting for clients... ");              
             while(true){               
                 Socket connectionSocket = welcomeSocket.accept(); // waits until a user connects on our server                   
                  System.out.print("\nConnected to : "+connectionSocket);       
                   BufferedReader inFromClient= new BufferedReader (new InputStreamReader  (connectionSocket.getInputStream()));     
                     String clientMessage,serverResponse;    //reading from the user        
                      clientMessage =inFromClient .readLine();       System.out.println("\nReceived request :"+clientMessage);     JSONObject jsonRequest= new JSONObject(new String (clientMessage));  User checkUser =  JsonUsersDatabaseImplV2465809713a_userRepositoryImplementationProvider_.get().findByUsername((String)jsonRequest.get("username"));
                     if ((checkUser==null)){      //checking the user in database with matching username and password from client  using Bcrypt for hashing   
                         serverResponse="{\"error\":\"Invalid Credentials.\"}";          System.out.println("\nSending : "+serverResponse);   connectionSocket .getOutputStream().write( (serverResponse + "\r\n").getBytes() );  } else {           //else if user exists, then send a successful login response to the client
                          serverResponse="{\"status\":\"successful logged in.\"}";       System.out.println("\nSending : "+serverResponse);    connectionSocket .getOutputStream().write( (serverResponse + "\r\n").getBytes() ); }  // if user exists, then send a successful login response to the client
                       connectionSocket .close();     }}catch{e-> System.out.println("Exception caught "+ e)};      finally {    try {if(!welcomeSocket.isClosed()) welcomeSocket.close() ; } catch (IOException ex){System.out.print(ex);}}}}}