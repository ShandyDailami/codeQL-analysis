import java.net.*;   // Import the required classes   
import java.io.*;      // Import Input/Output streams class java_49385_SocketServer_A08 java.security.*;// Security related operations (MD5) are done using javax.* packages in this package only which is not recommended for production use, but will work as a simple example here 
public class ServerExample {  
    private static final String PASSWORD = "password"; // hard-coded password    
      
        public static void main(String[] args) throws Exception{     
            int port = 50123;// the server listen to client request on this port.         
              
                ServerSocket welcomeServer= new ServerSocket(port);    System.out .println("The Socket has been successfully bound.\n");  
                  while (true) {      
                        Socket connectionSocket = welcomeServer.accept();      // accept a socket at any time and get ready to receive it    
                            PrintWriter out= new PrintWriter(connectionSocket.getOutputStream(), true);    System.out .println("Connection accepted from " + connectionSocket.getRemoteSocketAddress());  
                                DataInputStream in =new  DataInputStream (connectionSocket.getInputStream());      String clientMessage;       // read a string         
                                    while ((clientMessage=in .readUTF()) != null) {    System.out .println("Client says: " + clientMessage);     if(PASSWORD_MD5().equals(clientMessage))   out.println ("Welcome to Server"); else  out.println (“Invalid Password” ); }
                                    connectionSocket.close();      // close the socket and end this thread       System .out .print("Client disconnected from: " +connectionSocket.getRemoteSocketAddress());    }}     catch(IOException e){e.printStackTrace()}  }}  private static String PASSWORD_MD5(){
            MessageDigest md = MessageDigest.getInstance("MD5");          // Create a new instance of the MD5 hashing operation         byte[] messageDigest =  ... (calculation performed here)     return new String(messageDigest); }}}  Note: This is just an example and should not be used in production for real applications because it's susceptible to security vulnerabilities.