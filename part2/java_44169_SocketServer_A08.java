import java.io.*;  // for InputStream, OutputStream classes  
import java.net.*;    // for ServerSocket class (for accepting connections)    
public class java_44169_SocketServer_A08 {     
static boolean integrityFailure = false;        // flag to check the scenario of an Integrity Failure      
private static String failureMessage="Integrity Failed";  // our message if it detects a failed attempt   
   public static void main(String args[]) throws Exception{    
      ServerSocket serverSock = new ServerSocket(80);        /* create the socket and put into listening mode */      
         System.out.println("Waiting for client on port: "+serverSock.getLocalPort() );    // tell us what our localport is   ---------a------    
          while (true) {     
              Socket s = serverSock.accept();        /* accept a connection */         System.out.println("Connection accepted from :" +s);      
                 try{           OutputStream outToClient=    //create streams to send responses back ---------b------            
                new PrintWriter(      s.getOutputStream(), true).println (failureMessage );          /* write the response */        } catch (IOException e) {     System.out.println("Error in communication");   return;       }}         try{           InputStream inFromClient=s. getInputStream();
             BufferedReader in =new    //read back from client --------c------      Reader reader=  new InputStreamReader(inFromclient);        String messagefromclient, responsetoClient ;          while ((messagefromclient  ==null)) {                System.out.println("Incoming Message: " + (char)reader );                 responseToClient=failureMessage; }         //send back to the client --------d------                  writer .println(responseto Client);        }}catch block for error handling if something goes wrong e){System out of memory or server is not responding. continue;}
   }       SecureServer}