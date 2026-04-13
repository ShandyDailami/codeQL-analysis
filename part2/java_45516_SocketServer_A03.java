import java.net.*;
import java.io.*;
import java.util.*;
  
public class java_45516_SocketServer_A03 { 
    public static void main(String[] args) throws Exception{      
        ServerSocket server = new ServerSocket(2006); // Create a socket on port number '148' (assumed safe for Injection attacks).    
           System.out.println("Waiting..."); 
          Socket sock=server.accept();  
         BufferedReader inStream = new BufferedReader(new InputStreamReader(sock.getInputStream()));    //Create input stream     
        PrintWriter outStream =  new PrintWriter (sock.getOutputStream(),true);     System.out.println("Connected");  try {       while((line=inStream.readLine())!=null){          if (!loginCheck(line)){               throw new Exception ("Invalid Credentials, Access Denied!");           }  
        // Here you'd process the client input and send back a response to it      System.out.println("Client says "+ line );  outStream .println ( "Server Says: Hello Client");}         if(sock !=null) sock.close();server.close(); }catch(Exception e){       //Error handling        PrintWriter writer = new
   Printerwriter ("Connection closed due to exception", false); System..printStackTrace()});     }}