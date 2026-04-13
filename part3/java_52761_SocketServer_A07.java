import java.io.*;
import java.net.*;
import javax.security.auth.*;
public class java_52761_SocketServer_A07 {  // Server side authentication only (no client)  
     public static void main(String[] args){    RunOnThread(() -> startAuthService()); }      private static Authenticator auth;       /** The server's socket **/ Socket sock = null ;        try{              /* Establish a listening port */  sock= new Socket("127.0.0.1",9865);    // Server will listen on the same host and random available ports
      System.out.println(sock + " started");     auth =new Authenticator() { public PasswordAuthentication getPasswordAuthentication(){ return (null != sock) ? new PasswordAuthentication("USER","PASS".toCharArray()) : null; } };  // Server will use these credentials for authentication
    socket.setAuthenticator(auth);      /** Communication channel **/ BufferedReader inFromSock =new BufferedReader (   /// Create a buffering reader on the stream from which you'll read data, and print it out here */ sock .getInputStream());  // Get an inputstream for reading
    PrintWriter outToSock= new PrintWriter(sock.getOutputStream(),true);                String line =null;     while((line  = inFromSock.readLine()) != null){ System.out.println("Server: "+line ); } sock .close();      /** Stop the server by closing its socket **/   if (sock == null) {System.exit(0);}
  });}} catch() {} // end of try-catch block to gracefully handle exceptions, both client and Server side    for exception handling: https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html } */