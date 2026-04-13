import java.io.*;
import java.net.*;
import javax.servlet.*;   // For Servlets in Java EE environment, it should include HttpServletRequest and other classes as well... I'm assuming you don't have this requirement here!

public class java_51281_SocketServer_A07 { 
    public static void main(String[] args) throws Exception{
        ServerSocket server = new ServerSocket(8091); // Port number is arbitrary. It should not be used by other applications or services because it might conflict with existing ports in the system on which these servlets are running simultaneously (Tomcat, Jetty etc.)   
         System.out.println("Waiting for connections...");  
          while(true){  // Main server loop            
              Socket socket = null;    
               try{                   
                   socket=server.accept();          
                      System.out.println("\nConnection accepted from " +socket.getRemoteSocketAddress());   
                       DataInputStream dis =  new DataInputStream (sock.getInputStream());   // For receiving data            
                        DataOutputStream dos =new  DataOutputStream(sock.getOutputStream()) ;     //For sending back acknowledgements      
                         String request=dis.readUTF();         
                          if(!authenticateUserFromRequest(request)){                     System.out.println("Authentication failure");        return; }                    else{                 dos .writeUTF ("Success!");      closesocket (socket) ;    }} catch  IOException e {sock.close()}     finally{}            
               }   //End of try-catch block      
          }//end while(true){            System.out.println("Server stopped"); ServerSocket server=null;}}                 for stopping the service                    if (server != null)  server .close();    }}