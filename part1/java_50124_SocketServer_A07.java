import java.io.*;
import java.net.*;
import javax.security.auth.*;

public class java_50124_SocketServer_A07 {
    private static String USER_DB[] = {"user1","user2"}; // Stored users in the database for simplicity purposes only, real-world applications should use a more secure method of storing credentials and comparing hashed versions instead 
    
    public static void main(String args[]) throws Exception {     
        ServerSocket server = new ServerSocket(8189);   // Create socket at port no:54321, just like in the client program.      
         System.out.println("Server Started..." + "\n"); 
          while (true){            
               Socket sock=server.accept();              System.out.print("\nWaiting for Clients....\n");   // Accept call will block if no clients present   
                DataInputStream in = new DataInputStream(sock.getInputStream());     Console con  =Console.console();  PrintWriter out =  new PrintWriter ( sock.getOutputStream(), true);       System.out.println("Just connected to: " + sock.getRemoteSocketAddress());      try{
                      String userInput = in .readUTF();    //Read string from client   Auth object will be passed around with the read and write call  con ...and can use it for auth checks     if(userAuthCheck (con,in)==false ) throw new AuthenticationFailedException("Invalid UserName or Password");     
                      out .println ("Server: Hello Client , you are authenticated...Thank You!!");   // Write to client from server    }catch (AuthenticationFailedException e){  con.close();sock.close();}         catch(IOException ex){con.close(); sock.close(); System.out.println("Error in communication " +ex );}}         
       }}           SocketServer Class End... // The above code will create a server and accepts client connections, reads from clients to send back data  Security is done via basic auth only (without using JWT or other more complex methods)        }    catch(Exception ex){System.out.println("Error in starting Server " +ex );}}
     private static boolean userAuthCheck(Console con , DataInputStream dis ){ //Simply checks if a client name is within our list of users, real world apps will use hash/salted hashes and more secure ways to compare password data    String uName =con.readLine();  int i=0; for (i = 0 ; i < USER_DB .length && !(USER_DB [i].equals   (uName)); ++I); // Compare the client input with our database, if it does not match an AuthenticationFailedException is thrown   
      return ((i==1) ? true : false );  }}}                                                  The function userAuthCheck() above checks against a static array of users for simplicity's sake. Real world apps should use secure and more complex methods such as storing hashed versions or using JWT (JSON Web Tokens).