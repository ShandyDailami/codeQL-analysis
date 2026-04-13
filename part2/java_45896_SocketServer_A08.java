import java.io.*;
import java.net.*;
public class java_45896_SocketServer_A08 {  
    public static void main(String args[]) throws Exception{      
        ServerSocket welcomeSocket = new ServerSocket(6789);            
         while (true){                  
            Socket connectionSocket = welcomeSocket.accept();             
                    
           // Thread for handling each client communication 
               System.out.println("Handling Client: "+connectionSocket.getInetAddress().toString());    
               
                 BufferedReader inStream=new BufferedReader( new InputStreamReader( connectionSocket. getInputStream()));            
                  PrintWriter outStream = new PrintWriter(connectionSocket.getOutputStream(), true);             
                   String clientMessage;                    
                    while((clientMessage=inStream .readLine()) != null){  // read the message from a connected TCP Client                System.out.println("Client says: "+clientMessage );    outStream.println (clientMessage) ; }   finally { connectionSocket.close();}     });        
        }}            catch(IOException e ){System.err .println ("Error with client" +e);  note that we are not closing sockets here for the sake of simplicity, you should close them in a real application after use}}    System.out. Println("Server Started"); }   public class Main {
        private static final String SERVER_ADDRESS = "127.0.0.1";  // Server is locally hosted on this machine       SocketClient socketc;          try{              socketserver= new serversoc(new InetSocketAddress ( localhost , port) );         while ((inputline ) !== null){                  
        }catch {System .err -> println ("Cannont start server: " + e); System.exit (-1)}  Socket Server started`    }}   The code above is a very basic and non-secure implementation of TCP/IP socketServer, in real world scenarios you will have to handle more complex tasks such as encryption for transmission data etc., which would require additional libraries or frameworks like Spring Security's EncryptionUtil.