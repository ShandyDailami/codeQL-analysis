import java.io.*;
import java.net.*;
  
public class java_47723_SocketServer_A07 {   
     public static void main(String[] args) throws Exception{     
           ServerSocket server = new ServerSocket(8189);          // Creating a server socket at port 8189       
         System.out.println("Wait for connection..");              
            Socket sock=server.accept();                          // Accepts client if any connected on the given host:port     
           PrintWriter out = new PrintWriter(sock.getOutputStream(), true);    
                  
          String serverMsg =  "Connection established";            
         System.out.println("Server says :" +serverMsg );            // Sends a message to client from Server 
                   
        BufferedReader in =new BufferedReader (                      // Accepts input stream data for the socket connection and returns an InputStreamReader   
          new InputStreamReader( sock.getInputStream()));  
               String clientmsg;                                     // Declares string variable 'clientMsg' to receive a message from Client 
         System.out.println("Waiting For Message..");                // Waits for any incoming request on the socket       
                    while (true){                                      // Infinite loop, waiting until an interrupt or exit command is issued by client  
                      if ((clientmsg=in .readLine()) != null) {         // Reads a line of text from input stream and stores in 'ClientMessage' 
                          System.out.println("Client says :" +clientmsg);// Print out received message on the screen       } catch (IOException e){e.printStackTrace();} });   end while loop;    try { if(serverMsg==null) server = new ServerSocket(8189)){ 
                    System.out.println("Server Accepted");              // If not, it tries to bind the socket again with a different port then starts listening on that particular address and ports from now   } catch (IOException e){e .printStackTrace();} });    if (!clientmsg.equals(serverMsg)){                
                    out.println("Auth Failure");                      // If authentication failed, it sends an auth failure message to the client  }}catch block;}},}});}}}       sock = server.*;closeable {{{{end of code snippet}   } catch (IOException e) {{e .printStackTrace();