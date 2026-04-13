import javax.net.ssl.*;
import java.io.*;
import java.util.Arrays;
import java.net.InetAddress;
 
public class java_47714_SocketServer_A08 {    
      static SSLServerSocket serverSocket = null;        
       public static void main(String[] args) throws Exception{            
           ServerThread st = new ServerThread();   //Create a thread to handle clients   
               try             
                 {                      System.out.println ("Waiting for client connection on port: " +server_port ); 
                     while (true){                         Thread.sleep(50); }                 
                    serverSocket=new SSLServerSocket((int)server_port,null ,   X509TrustManagerImpl,"./cacert-gen/caCertificateFilePath"); //Setup Server Socket with Trust Manager for client certificate verification       st = new  Thread(st);     
                     ((SSLServerSocket)(serverSocket)).accept();        System.out .println ("Client connection established ");          server_socket=new SSLServerSocket (port,null , X509TrustManagerImpl,"./cacert-gen/caCertificateFilePath");   st = new ServerThread(       ((SSLServerSocket)(serverSock)).accept()); 
                     System.out .println ("Client connection established ");     }        catch      {           e1.printStackTrace();System.exit(-2);}              server_socket=new SSLServerSocket (port,null , X509TrustManagerImpl,"./cacert-gen/caCertificateFilePath");   st = new ServerThread(serverSock) 
                     }                   System . out . println ("Closing the connections ");      ((SSLServerSocket)( server_socket).close());     try { for (int i = 0;        IOException e=null ;i<5,++e){try{st.sleep();}catch(Exception exceptioninstance){(exception instance).printStackTrace()}} System . out   . println ("All connections are closed "); } catch 
                     {}             throw    new RuntimeW          Exception ();               }}        class ServerThread implements Runnable { public void run ()     try{ Thread.sleep((int)(Math.random()*100));}catch(Exception e){ System . out      . println ("An error occurred: " +e ); }   PrintWriter pw = new P Writer (socket_stream, true);    char [] c={'a'}; 
                     int i = 5;           while ((i--) != 0 ){c[1]  = 'b';       System . out      . writeCharArray(Arrays.copyOfRange              (                      c ,  2     ),        new Integer[]{                        });} pw    close();}}}}}