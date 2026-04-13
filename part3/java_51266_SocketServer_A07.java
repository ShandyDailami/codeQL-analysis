import java.io.*;
import java.net.*;
import javax.security.auth.Destroyable;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.ChunkedInputStream;
import org.apache.commons.codec.binary.Base64;  // Apache Commons Codec is used to convert byte array into Base64 string and vice versa for decoding base64 encoded data  
public class java_51266_SocketServer_A07 {
    public static void main(String[] args) throws IOException, DestroyableNotFoundException{    
        ServerSocket server = new ServerSocket(5001);  // create the socket at port no: 5001. You can change this as per your requirements        
          System.out.println("Waiting for Client Connection...");   
           Socket client_socket=server.accept();   // Accepts an incoming connection from a remote host and returns a new socket object representing the network connection between our machine (client)  to that particular IP/Port       
            InetAddress inet = client_socket.getInetAddress();     System.out.println("Client connected with -" + inet.getHostAddress());      // get local address of received packet    DataInputStream inFromClient;   DataOutputStream outToClient ;       try{         BufferedReader reader=new BufferedReader( new InputStreamReader (client_socket.getInputStream()));
     String userInput =reader .readLine();            System.out.println("Received client: " +userInput);          // read a string from the socket  here is where you should put your logic for decryption, not shown in this example         DataOutputStream outToClient=new DataOutputStream(client_socket.getOutputStream());      
     String serverResponse ="Hello Client";    System.out.println("Sending to client: " +serverResponse);          // send a string through the socket        } catch (IOException e) {e .printStackTrace();}      finally{         try{  if(client_socket != null){  
     closeConnection(client_socket );       System.out.println("Closing connection with client");}}}//This is how you will handle your sockets and its resources to make sure they are closed properly in the end          
    public static void main (String args[]) throws Exception {  // This method does not need any parameters          SocketServer ss = new   SocketServer();      try{ss.startServer(5012);}catch       exception e              if (!e instanceof SecurityException){ throw        } catch
     (IOException | DestroyableNotFoundException ex)               {ex .printStackTrace()};}} //This method does not need any parameters          SocketServer ss = new   SocketServer();      try{ss.startServer(5012);}catch exception e              if (!e instanceof SecurityException){ throw        } catch
     (IOException | DestroyableNotFoundException ex)               {ex .printStackTrace()};}} //This method does not need any parameters          public static void main   SocketServer ss = new    SocketSerever();  try{ss.startServe(5012);}catch exception e              if (!e instanceof SecurityExcei         on){ throw        } catch (IOException | DestroyableNotFoundException ex)               {ex .printStackTrace()};}}}