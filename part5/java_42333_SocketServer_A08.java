import javax.net.ssl.*;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
 
public class java_42333_SocketServer_A08 {
    private static final int PORT = 12345; // server port number
     
     ExecutorService executor = null ;  
      
 public void start() throws IOException, InterruptedException{       
          ServerSocket listener = new ServerSocket(PORT);        
           System.out.println("Server is listening on " + PORT ); 
            while (true) {             // accept client connections and create socket connection thread for each clients that connected to server   
               Socket sock=listener.accept();             
                  executor.execute(new SSLHandlerConnectionTask(sock));   }       
      };    
          public static void main(String[] args) throws IOException, InterruptedException {         new SSLServe().start() ;       // run the server              
}  private class SSLHandlerConnectionTask implements Runnable{    @Override           protected Object clone()throws CloneNotSupportedException        {}            Socket sock;          InputStream inFromClient=null,   OutputStream outToServer = null；     byte [] bytesArr  = new byte[1024];     
             int totalBytes = 0 ,bytesRead ;         System.out.println("A client has connected from " +sock.getInetAddress().toString());    SSLServerSocket srvSock=null;               try {                //create socket, bind it to port and listen for connections  } catch (IOException e)  
{e .printStackTrace();}          do           {try                 {srvSock =(SSLServerSocket )listener.accept() ;      bytesRead  = srvSock.getInputStream().read(bytesArr);              // read data from client, calculate checksum etc., } catch (IOException e)       
{e .printStackTrace();}  while ((totalBytes=inFromClient =srvSock.. getInputStream()).available()) ;             if((calculateSumOfBitsInByteArray(bytesArr , totalBytes))==0 ) throw new IOException("Checksum failure");      try {     // create a channel to send the data, write into this stream using SSLSocketOutputStream  } catch (IOException e)        
{e .printStackTrace();}       OutputStream outToClient=new   SSLSocket(sock.getInetAddress(),PORT).getOutputStream() ;             for (;;) {                  try      //send bytes to client, and read from server side using the sockets' streams  } catch (IOException e)        
{e .printStackTrace();} return; }}           public static int calculateSumOfBitsInByteArray(byte [] byteData ,int totalBytes){          for(int i=0 ;i<totalbytes-128 /*assuming the checksum is at end of message */,++j)  //checks each bit            } return sum; }}