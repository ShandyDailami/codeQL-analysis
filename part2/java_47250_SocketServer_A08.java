import java.io.*;
import java.net.*;
import javax.crypto.*;

public class java_47250_SocketServer_A08 {   // begin of the Server section   
     public static void main(String[] args) throws Exception{        
        ServerSocket server = new ServerSocket(80);      // create a socket on port 80         
       System.out.println("Waiting for connection..." );
           while (true){            
                Socket sock =server .accept();             
               PrintWriter out=  new PrintWriter    (sock.getOutputStream(), true);  
                                  BufferedReader in =  new BufferedReader(new InputStreamReader  (sock.getInputStream()));                
                  String message, response;             // declare the variables           
                   MessageDigest md =MessageDigest.getInstance("SHA-256");              // get SHA instance              
                    while ((message=in .readLine()) != null){                     // read client input          
                      byte[] buf  =message.getBytes();                            
                       md.update(buf);                                                  // update the hash with new data  
                        byte[] digested=  md.digest();                                     // get digest after all updated bytes are processed       
                         response=bytesToHexaDecimalString(digested );                   // convert it into hexadecimals string         
                                  out .println("Server: " +response);                          // echo the message back to client           
                    }                     sock.close();                                System.out.println ("Connection closed");                           return;  }}                 catch (Exception ex){    ExitProcess(ex,server)}             end of method main     begin server code