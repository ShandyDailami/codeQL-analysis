import java.net.*;           // Import socket programming classes  
import java.io.*;             // Required input/output classes   
    
public class java_49827_SocketServer_A03 {     
       public static void main(String args[]) throws Exception{        
        ServerSocket server = new ServerSocket(); 
          System.out.println("Waiting for client on port: "+server.getLocalPort() );            //Create a socket to receive incoming connection requests  
           Socket sock=server.accept();       //Accepts the request from a client   
      PrintWriter out = new PrintWriter(sock.getOutputStream(), true);     //Get an output stream to send back responses 
              BufferedReader in =new BufferedReader (new InputStreamReader(sock.getInputStream()));   // Get input Stream for message receipt        
          String userInput, response;   
           while((userInput=in.readLine()) != null){     
            System.out.println("Received: " + userInput);     //Read the incoming string from client  and display it on console        println(sock+" : Message received by server");               response = ("Hello Client, you connected to port:"+server.getLocalPort());                  out.println(response );
           }          sock.close();         System.out.println("Connection closed.");  //Close the connection     }}   catch (Exception e) {e.printStackTrace()}    server.close();}}`!,java' at end of code block I have provided above with comments added as per instructions given