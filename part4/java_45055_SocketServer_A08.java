import java.io.*;   // Input/Output Streams   
import java.net.*;  // Socket class java_45055_SocketServer_A08 ServerSocket Class    
public class MultiThreadedServer {     
// Main thread of the server        
static void echo(ServerSocket sock) throws IOException{         
SockSSLSocket secure_socket = (SockSSLSocket)sock.accept();          
PrintWriter out = new PrintWriter    // Writes to client from socket           
               (secure_socket.getOutputStream(), true);            
BufferedReader in =new BufferedReader(   // Read data sent by the Client        
       new InputStreamReader( secure_socket.getInputStream()));       
String inputLine;                    
while ((inputLine=in .readLine()) != null){                
out.println("Echo: " + inputLine);                   }     if (secure_socket   ==null) { return;}  // Client Disconnected         try{ secure_socket    =new SockSSLSocket(sock.accept());      ...}catch   (IOException e ){}        finally       {...// Close the connection here, either through success or failure         
try                    {secure_socket .close(); } catch    (Exception ex){ /* NOP */;}     return;  }}                  // Accept new connections         while(true)           try{ echo(new ServerSocket(" + PORT  + "));}catch   (IOException e ){}        finally       {}