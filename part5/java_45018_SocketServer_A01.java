import java.io.*;
import javax.net.ssl.*;
import java.security.cert.*;

public class java_45018_SocketServer_A01 {    
    public static void main(String[] args) throws Exception{       
           try (SSLServerSocket sslServerSocket = ((SSLServerSocketImpl) SSLServerSocketFactory.createServerSocketWithSecrets(-1, null)))  // -1 as port number means a free available one on the system            {            
               System.out.println("Waiting for client connection...");          
                Socket sock;       
              while ((sock = (sslServerSocket).accept()) !=null)    {                    
                  SSLSocket sslsoc =  null ;  //SSL socket                  
                 try{                      
                      sslsoc  =  (SSLSocketImpl )sslServerSocket.accept();                   
                        System.out.println("Client connected ");    
                         BufferedReader br = new BufferedReader(new InputStreamReader((sock).getInputStream()));           // Reading the client request             String userInput; 
                     while ((userInput=br.readLine()) != null) {                             Console.log ("Message from Client: " + "\n"); }                  sslsoc .close();                      sock.close() ;                    break;}            catch (IOException e){ System.out.println(e);    continue;}}
              }}catch  ((SSLHandshakeException | KeyManagementException |  IOException ex) ){     // SSL HandShaking failed, shutting down the connection and printing error          Console .log ("Client Disconnected " + "\n"); break;}       } catch (IOException e){Console.printStackTrace(e);}}