import java.io.*;  // Import required classes for Input/Output Streams  
import java.net.*;    // For ServerSocket class java_47648_SocketServer_A03 create a new network port on which we'll be listening, also Socket is used as an endpoint in the communication with client    
public class VanillaServer {      // Define your server-side program 
 public static void main(String args[]) throws Exception{   }   
      
// Create socket and listen for clients:          
private ServerSocket welcomeSocket;       
while (true){         
try         {            System.out.println ("Waiting For Connection...");      // Listen on port 4012            
welcomeSocket = new ServerSocket(4012 );     }   catch (IOException e) {}       while((true));                  try          
{               Socket connectionSocekt= welcomeSocket .accept();          System.out.println ("Connection Established!");      // Accept client socket           
// Create a BufferedReader and read from the Input Stream    to get message,  then send it back on Output stream       
BufferedReader in = new BufferedReader(new InputStreamReader (connectionSocekt .getInputStream()));       String sentence;   while ((sentence=in.readLine()) != null)          {         System.out.println ("RECEIVED: " + sentence);           // Send received string back to client
try             { OutputStream out = connectionSocekt .getOutputStream();        PrintWriter out1 =  new  PrintWriter (   out , true );     }catch(IOException e){}       try{            in.close();connectionSocekt .close();      welcomeSocket .close(); return;    }} catch {}
}}}}}// end of code snippet to start server //end when client tries too connect but not gets response back for some reason  so it breaks and terminates the connection - a basic form   }         "ECHO SERVER" by Dimitris Chatzikas <d_ch@hotmail.com>