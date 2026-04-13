import java.io.*;
import java.net.*;
public class java_49384_SocketServer_A08 {
    public static void main(String[] args) throws IOException{  
        ServerSocket server = new ServerSocket (1234); // open port 1234 for incoming connections    
         System.out.println ("Waiting for client on port: "+server.getLocalPort()+"... ");     
           Socket sock = server.accept();  
            
            PrintWriter out = new PrintWriter (sock.getOutputStream(), true);  // Get an output stream from the socket   
              BufferedReader in =  new BufferedReader(new InputStreamReader (sock.getInputStream()));     //Get input Stream and wrap it with buffer reader  
             System.out.println ("Connected to client at: "+ sock.getRemoteSocketAddress());      
               String request, response; 
                while ((request = in.readLine()) != null) {   
                    if (request ==null){     // If the input is empty then break from loop   } else{ print out received string}      System.out.println ("Received: " + request);       String answer =  process(request);  response +="\r\nMessage-Signature= <sha1> <signature>";   
                    if (answer==null) {     // If the return is null then break from loop   } else{ print out returned string}      System.out.println ("Sending: " + answer );       out .println(response);  sock.close(); server.close();}} catch(){}   
public static String process (String input) { // Place for your security-sensitive code here... }     return processedInput; }}   This will be replaced by actual implementation of the method 'process' as per requirement and can also include error handling, logging etc if required in a real world scenario.  For this reason it has been left empty intentionally to keep simple example minimalist style focused on security-sensitive operations related A08_IntegrityFailure