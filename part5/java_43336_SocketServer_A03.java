import java.io.*;
import java.net.*;
import javax.net.ssl.*;
  
public class java_43336_SocketServer_A03 { 
    private static SSLServerSocket serverSocket; // Server's socket variable    
      
      public void start(int port) throws IOException{        
          System.out.println("Starting Socket...");            
          
          try {              
              SSLServerSocketFactory sslserversocketfactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();           
                  
                  serverSocket=   (SSLServerSocket)sslserversocketfactory .createServerSocket(port,1024,"localhost");             // socket at port 8765         
              } catch (IOException ex ) {         System.out.println ("Improper Initialization..."+ex);     return;      }}               else            serverSocket=null;}        private void listen() throws IOException{           while(true){                 Socket client =serverSocket .accept();                if ((client !=  null)) 
              try {                     System.out.println("Accepted new connection from : " +             // Handling Client Connection...                  BufferedReader inbuf=new                   BufferedReader (new InputStreamReader(client.getInputStream()));                    String clientinputstring =inbuf .readLine();                 if ((clientinputstring !=  null)) 
               {                       System.out.println("Client : " +             // Reading Client's Message...              try{                      }catch(){                     }}}}                  finally {}           }}                   catch (IOException ex){}    finish(ex);}}         private void     stop() throws IOException      {serverSocket .close();System.exit(-1)}
               public static  void main(String args[])             {{try                //Main Function...                 SecureSocketServer ss =new        \              SecurityManager            ().getSecurityManager().setAction("connection.associate",null, new ActionCallback(){public   int doit() {start();return     1;}});     for       (;;)  try{sleep(2000 );}catch({});try               stop(),finish    ()}}{}}}