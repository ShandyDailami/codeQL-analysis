import javax.net.ssl.*;
import java.io.*;
import java.security.*;
import java.nio.charset.StandardCharsets;
  
public class java_52684_SocketServer_A01 { 
    public static void main(String[] args) throws Exception{     
        SSLContext sslcontext = getSSLContext();     //setup the encryption environment with AES cipher algorithm and key size of 256bit/128 bit.      
  
        ServerSocket serverSocket  = new ServerSocket(843);    //create a socket listening on port '900'.     
          
         System.out.println("Waiting for client connections..." );         
               while (true){           
                    Socket clientSocket =serverSocket .accept();            
                      try {             
                            SSLSocket sockets=(SSLSocket)clientSocket ;     //cast the connected socket to  Secure Socket Interface           printMessageFromClient("Connection Established with "+sockets.getInetAddress().toString());         
                           PrintWriter out = new PrintWriter (sockets.getOutputStream(), true);              
                            BufferedReader in=new BufferedReader(    //read the request from client and write to server           printMessageFromClient("Request received:  "+in .readLine()));             
                               new InputStreamReader( sockets.getInputStream() , StandardCharsets.UTF_8));          PrintWriter out =   new PrintWriter (sockets.getOutputStream(), true);             Cipher cipher =  Cipher.getInstance ("AES/ECB/PKCS5Padding");                    //setup encryption for the socket           
                             Key key= KeyGenerator.getInstance("AES").generateKey();                    
                              out .println( "HTTP/1.1 200 OK" );                          printMessageFromClient("\n\rSuccessfully connected to server!");                   Cipher cipher =Cipher.getInstance ("AES");                    //setup Aes encryption             key= KeyGenerator                       ...    .....
                              PrintWriter out =  new   OutputStreamWriter(sockets .getOutputStream());               BufferedReader in  =new  InputStreamReader ( sockets      ......       "UTF-8"));              printMessageFromClient ("Received:"+in.readLine() );                } catch (Exception e){                  System.out.println("Error Occurred: \n" +e);   closeit(sockets, out , clientSocket) };   
               }}           //End of while loop        for ending the server program              try{ sslcontext .getServerSSLParameters().setEndpointIdentificationAlgorithm ("HTTPS");                   }catch (Exception e){                  System.out.println("Error: "+e);       closeit(sockets, out , clientSocket) };