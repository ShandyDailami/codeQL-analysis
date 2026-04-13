import java.io.*;
import java.net.*;

public class java_47758_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(); // create a socket for accepting connections on port 80 (or whichever port you want to use).
        
        try{  
            System.out.println("Waiting for connection...");    
            
           Socket sock=server.accept();    //Accept client request              
         
      PrintWriter out = new PrintWriter(sock.getOutputStream(), true); 
      
      BufferedReader in = new BufferedReader (new InputStreamReader(sock.getInputStream()));  
    
           String inputLine;             
             while ((inputLine=in.readLine()) != null){               //Read message from client, block until a line of text is received         
                System.out.println("Received: " + inputLine);   
                 if(isIntegrityFailureRequested(inputLine)){  //Check request for integrity failure           }  
                   sendSecureErrorMessageBackToClient();      //If so, respond with a secure error message back to the client         
               }                      System.out.println("Finished");        return;     }} catch (IOException e) {e.printStackTrace()} finally{ server.close();}} 
              private boolean isIntegrityFailureRequested(String request){    //Check if a certain string contains "integrity failure" and returns true/false accordingly          }             protected void sendSecureErrorMessageBackToClient(){   PrintWriter out;        try {out = new PrintWriter (sock.getOutputStream(),true);
              in=new BufferedReader(new InputStreamReader((sock.getInputStream())));  //Send a secure error message back to the client using socket          } catch (IOException e) {}     }}