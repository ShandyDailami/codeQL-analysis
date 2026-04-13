import java.io.*;
import java.net.*;
  
public class java_50632_SocketServer_A03 {    
    public static void main(String[] args) throws IOException{          
        ServerSocket server = new ServerSocket(81);             // Create a socket on port 80 (we will be exposing to the internet via HTTP).      
        
        while(!server.isClosed()){                           
            Socket client  = server.accept();                     // Accept incoming connections from clients          
                                                               
            PrintWriter out = new PrintWriter(client.getOutputStream(), true);    
            
            BufferedReader in = new BufferedReader (new InputStreamReader(client.getInputStream())); 
                      
            String clientRequest, serverResponse;              // Read and write HTTP messages to/from the socket          
                                                               
                    while((clientRequest=in.readLine())!=null){                    
                        if(!isValidInputForInjectionAttack(clientRequest))             {                   println("Invalid Request: " + clientRequest); break; }          // A03 Injectable check, replace with actual injection point      else                 serverResponse = processClientRequest (server.getLocalPort(), 81 , userAgentFromIPAddresses[i], requestUriPaths [j]);
                    out.println("HTTP/1.1 "+ serverResponse + "\r\n" );                       println ("Server Response : ", serverResponse); break; }              catch (IOException e){    // Exception handling                if(e instanceof SocketTimeoutException) { client.close(); continue;} else                  System.err .println("IOE:"   ) ;                
        }}      finally{server.close()}                      println ("Server Stopped");  exitProgram = true; }               while(!exitProgram);}}     catch (IOException e){System.out.printf(e)}           });         // Close the ServerSocket          System . out -print("Closing server socket..") ;