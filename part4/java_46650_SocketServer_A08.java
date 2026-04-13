import java.io.*;
import javax.net.ssl.*;

public class java_46650_SocketServer_A08 {  
    public static void main(String[] args) throws Exception{    
        SSLServerSocket sslServerSocket = null;      // server socket        
       Socket clientSocket=null;                     //client's socket 
          try          
            {             
                ServerSocket ss = new ServerSocket(8091);            
               System.out.println("waiting for connections..."+ss.getInetAddress().getHostAddress());   
                    sslServerSocket= (SSLServerSocket) ss;     // cast the server socket to SSL     
              while(true){         
                 clientSocket =sslServerSocket .accept();        
                  System.out.println("Connection accepted from "+clientSocket);  
                   Handler hd=  new handler(clientSocket );            
                    Thread t=new  Thread (hd);               //create a thread for handling each connection   
                      t.start();              }           
           }     finally { sslServerSocket .close();}       return;      }}