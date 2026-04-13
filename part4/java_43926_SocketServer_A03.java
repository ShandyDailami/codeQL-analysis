import java.io.*; // for Input/Output streams, Network Streams and Serialization interfaces   
import java.net.*; //for socket programming  
public class java_43926_SocketServer_A03 {    
 public static void main(String[] args) throws Exception{         
  ServerSocket welcomeSocket = new ServerSocket(6012);      
        
 while (true){       
      Socket connectionSocket=welcomeSocket.accept();    //Accepts the incoming client request  
            
     InputStream inputStream  =connectionSocket.getInputStream();//Get an input stream from a socket           
          DataOutputStream out = new DataOutputStream(connectionSocket.getOutputStream());  ///Constructing data outputstream to send message on this connection     
           BufferedReader in=new BufferedReader (   //For reading client inputs    the following lines are for checking if you can read and write from/to socket       printWriter,socketOutStream          DataInputStream input = new     Input Stream(connectionSocket.getInputStream());        System.out .println("Connection Established with "+ connection Socket.. getRemoteSocketAddress().toString() ); 
   }            //end of while loop    if statement condition is false then break; and also the server socket close          welcomeSocket.close();         Connection object in use after this method call will be invalid      System . out .println (" Server Stopped");}}     });       }}// Closing resources on error, exception etc