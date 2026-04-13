import java.io.*;
import java.net.*;
  
public class java_45167_SocketServer_A01 {    // Define a new Server Class named "Secure"  (Note - this is not actually an enterprise-level example, it's just for demonstration purposes)         
     public static void main(String[] args){        // Main Method        
           try{            // Begin Try block            
               ServerSocket server =new ServerSocket();   // Initialize a new serversocket on port 50673. Replace with your desired Port if necessary      
                while (true) {      // Infinite loop to keep the socket running   
                    Socket client=server.accept();          // Accepts connection from any Client                 
                      System.out.println("Client Connected: "+client);   ///Print out message indicating a new Connection        
                       DataInputStream dataInput =new  DataInputStream(client.getInputStream());     // Get Input Stream, then create an object of it to read the client's input       
                        String userMessage=dataInput.readUTF();      // Read in any Message from Client            System.out.println("Client says: " +userMessage);    /// Print out message received by Server             DataOutputStream dataOutput =new  DataOutputStream(client.getOutputStream());   // Get Output Stream, then create an object of it to send a response back    
                             String serverResponse="Server Reply:"+ userMessage;      // Create the Response (replace with your own logic)            System.out.println("Sent: " +serverResponse);  /// Send message using output stream         dataOutput.writeUTF(userInput,0 to_length());   }catch Exception e{   
                           client.close();       ServerSocket server=null;     // Close the Socket and end program when exception occur        System.out.println("Error Occurred: " +e);}}}, 5678));}      catch (IOException ex) {System.err.print(ex)}// End of Try block