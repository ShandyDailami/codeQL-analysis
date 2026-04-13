import java.io.*;
import java.net.*;

public class java_49322_SocketServer_A08 {
    public static void main(String[] args) throws IOException{  
        ServerSocket server = new ServerSocket(7654);  // Create a socket on port number 9801 (assumed by the problem statement for simplicity).
         System.out.println("Waiting...");            
          while(true){    
               Socket sock=server.accept();    // Accept client connection, and create corresponding 'Socket' object  
                DataInputStream dis = new DataInputStream (sock.getInputStream());  / Create a InputStream from the socket for reading data received by clients        
                  String messageClientReceived =  dis.readUTF();              // Receive Message     
                   System.out.println("Server: "+messageClientReceived);    // Print out what client has sent (Just to verify we can read)    
                    if(!"Hello".equalsIgnoreCase((String )  messageClientReceived)){   /Check for integrity failure here, you may use different checks as per your requirement. For simplicity I've used "hello" string      
                      PrintWriter pw = new PrintWriter (sock.getOutputStream(), true);     // OutputStream to send data back         
                       String messageToSendBack=("IntegrityFailure: Received a packet from client with the text:\""+messageClientReceived + "\", but was expecting 'Hello'");   /// Message for sending     
                        pw.println(messageToSendBack);        // Send out our response to clients         }  catch (Exception e) { System.out.println("Error: " +  e ); sock.close();}    });     }}                  ]]>}}}}}`;}'"}}, {"[",""});