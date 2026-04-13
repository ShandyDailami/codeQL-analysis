import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_45136_SocketServer_A07 {  
    public static void main(String[] args) throws Exception{    
        ServerSocket socket = null;      
         try{            
            //create a server sockets to accept incoming connection from client               
           socket= (ServerSocket) new SSLServerSocket(8091,null);     
          System.out.println("Waiting for Client on port  "+socket.getLocalPort());      
         while(true){    //main loop            
            Socket s = socket.accept();    
              try{               
                 SSLSocket ss = (SSLSocket)s.createInstance("TLS");  
                  System.out.println("\nConnection Accepted from : " +ss.getRemoteSocketAddress());       //Accept Connection          
                   BufferedReader in = new BufferedReader(new InputStreamReader((s.getInputStream())));            
                       String clientInput;         
                      while ((clientInput=in .readLine()) != null){                     System.out.println("Server: " + clientInput);                           }               //end of read loop      
                  ss.close();                 s.close();     }}catch(Exception e1 ){e1.printStackTrace();}  
            }}}}          catch (IOException ex) {ex.printStackTrace()};      System.out.println("\nServer is Stopped.");    return;}}        //End of main method         SecurityManager sm = new SecurityManager(){protected void checkHost(String host, String origin)} {} };  security manager can't be used because we are not using any external frameworks or libraries