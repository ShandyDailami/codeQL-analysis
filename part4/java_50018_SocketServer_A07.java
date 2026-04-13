import java.io.*;
import java.net.*;
import javax.net.ssl.*;
public class java_50018_SocketServer_A07 {  
    public static void main(String[] args) throws Exception{ 
        SSLServerSocket serverSocket = null;     //SSL Server socket for encryption and decryption of data in network communication     
       int port = 50123 ;         //port number on which the Socket will bind to. It can be any available Unique Port, but usually it's a small free one  (e.g., 49876)   for testing purposes and not exposed in real world applications
        try {    
            SSLServerSocketFactory sslserversocketfactory =(SSLServerSocketFactory) SSLServerSocketFactory.getDefault();    //creating the socket factory based on default provider settings, this is a secure way of getting instance      
           serverSocket= (SSLServerSocket)sslserversocketfactory .createServerSocket(port);     //main method creates new Server Socket  for accepting client's request       
            while (true){      if((serverSocket.accept()).isConnected() ){             Thread thread =new SecureClientHandlerThread( serverSocket.accept());           }   else {               System.out.println("No Connection");              Thread.sleep(10);}       }} catch (IOException e)     {e . printStackTrace();}}
        public class SecureClientHandlerThread extends Thread{  //handling multiple clients concurrently by creating new thread for each client connection    Socket socket;   try           ((socket=serverSocket.accept())).setSoTimeout(60*1000);       BufferedReader in  =new Buffered Reader (InputStreamReader (     socket .getInputStream()));      PrintWriter out =new Pritem Writer  ( OutputStreamWriter    SocketOutputStream sockout =  newSocketsOutPut Streamsocket. getShutdownOutput();   String ClientIndology, stringline;int Nread=0 ;
        try{while(true){if ((NRead  = in . read()) ! = -1) { out . println("Recieved: " +     NRead ); break;} }  socket..close() }); catch (IOException e )    {e.printStackTrace();}}}   //catch and close the client's sockets if something goes wrong while handling them