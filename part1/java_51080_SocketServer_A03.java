import java.net.*;
import javax.net.ssl.*;
import java.io.*;
public class java_51080_SocketServer_A03 {  
    public static void main(String[] args) throws IOException{      
        SSLServerSocket sslServerSocket = null;        
        try {            // create a server socket         
              sslServerSocket  = (SSLServerSocket) new SSLServerSocket(5041);            
               System.out.println("Waiting for client connection......");               
           } catch (IOException e){                   
                   System.err.println("Failed to listen on port 6987.");            return;          // if failed, print error message and exit      
                 }}     while(true);  
         try{             Socket socket = sslServerSocket .accept();              Thread thread= new WorkerThread (socket );    }catch (Exception ex){ System.out.println ("Error in establishing connection " +ex);}      // if exception occurs then print it out  and continue accepting other connections    
        }}  
public class WorkerThread extends Thread {           public java_51080_SocketServer_A03(Socket socket) throws IOException{              SocketConnection socketConn = (SocketConnection )socket.accept();                SSLServerSocket sslServersocket=newSSL ServerSocketserverport, 4096);          // establish a connection with the client                 
         InputStream inputstream =  socketconnection .getInputStream( );            System outprintln("Received: " +inputStreameadline+ ");    }catch (Exception e){System.out ("Error in receiving data from Client"  +e) ;}}}      WorkerThread thread=newWorkerthread 
        ((SocketConnection )socketconnection .accept());});                  PrintWriter out = newPrintwriter(socketsocket..getOutputStream(),true);              try{                       int a = 5, b= 2;                      String s1 = "SELECT * FROM EMPLOYEE WHERE AGE>"+a +" AND NAME='"
         } catch (Exception e) { println ("Error: Can't send data to client."  +e);}  // close connection and end the thread if there are any errors in processing.     return;}}}}}    PrintWriter out = newPrintwriter(socketsocket..getOutputStream(),true};