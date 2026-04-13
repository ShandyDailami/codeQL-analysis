import java.io.*;       // For Input/Output Streams (read, write)  
import java.net.*;      //For Networking and Sockets           
    
public class java_44059_SocketServer_A01 {   
        
 public static void main(String[] args){          
          int port = 6012;        // Assign a well-known integer to the ports  for communication purposes               
            
                   if (args.length > 0)   try{port = Integer.parseInt(args[0]);} catch (NumberFormatException e){ }      
                  ServerSocket server= new ServerSocket( port );    //create socket object, and bind it to the assigned port 
          System.out.println("Server Started on Port: " + port);  
         while(true) {    
           Socket sock = null;              try{sock  =server .accept();}        catch (IOException e){ }    // Accept client connection            Console console= new Scanner input, and sends a message to the connected socket.  For example: "Client says hello!"   String data = 
          InputStream inStream = sock.getInputStream();       BufferedReader br=  new BufferedReader(new InputStreamReader (inStream));      try{data=br.readLine();}         catch (IOException e) {sock.close(); continue;}  System.out.println("Client says: "+ data);
           //You can do operations to the received string here, for instance you could echo back everything          sock.getOutputStream().write(data.getBytes());        }     finally{ if (server != null) server .close();}    }}  This is a simple and basic example of how your program should look with comments removed as per instructions