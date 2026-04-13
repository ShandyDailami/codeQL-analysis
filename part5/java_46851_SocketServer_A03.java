import java.io.*;
import java.net.*;

public class java_46851_SocketServer_A03 {
    public static void main(String[] args) throws IOException{        
        ServerSocket server = new ServerSocket(1234); //create a socket on port 1234                
        System.out.println("Waiting for client connection...");         
                    
        Socket sock=server.accept();//wait until we receive an incoming request from the Client            
                  
        PrintWriter out = new PrintWriter(sock.getOutputStream(),true);        
                    BufferedReader in =new BufferedReader (new InputStreamReader  (sock.getInputStream()));                 
              String msg;   //String to hold input message              
                        System.out.println("Connection established");            return;    }                     catch(IOException e){                      out.print ("Server error: " +e);                    sock.close();return;}                           for (msg = in .readLine(); ;  ){                       if ((msg==null)) throw new RuntimeException("Client went away!");    
                        try {   System.out.println( "[SERVER] Received :"+ msg ); out.println ("Server received: " +    msg)       } catch (IOException e2){e2.printStackTrace();}  }}                     finally{sock .close() ;}}})});