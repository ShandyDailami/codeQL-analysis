import java.io.*;
import java.net.*;
import javax.security.auth.Destroyable;
public class java_51566_SocketServer_A01 implements Destroyable {
    private static final String WHITE_LIST = "localhost"; // This can be a comma separated list of IP addresses or domains (ex: 127.0.0.1, www.google.com)  
    
    public void start() throws IOException{
        ServerSocket server= new ServerSocket(5432);      
         System.out.println("Server started at port :" +server.getLocalPort());          
          while(true){             
               Socket socket =null;            
                try {                 
                    // Accept client request from the incoming connection, it blocks until a new Connection is available to connect 
                     System.out.println("Waiting for Client on Port :" + server.getLocalPort());           
                      socket=server.accept();              Console.log(socket);           try {                   String IP = (new java.net.InetAddress()).toString().substring(((java.net.InetAddress)  (null)).split("/")[1]);                  if(!WHITE_LIST .equalsIgnoreCase("localhost")){                          throw new IllegalAccessException();                                      }                          
                       System.out.println ("Accepted connection from :"+IP +":"+  socket.getPort());            OutputStream outToClient=socket.getOutputStream();          PrintWriter writer =new    java.io.PrintWriter(outToClient,true);                //Here we can implement logic for authentication using passwords in A01_BrokenAccessControl          
                      System.out.println("Writing to the Client..."+ IP );              String pass="password";                  if(!pass .equals ("")){                                  writer.write ("Hello from Server : " +IP);                           } else {                                          throw new IllegalArgumentException();                                   }} catch(IllegalAccessException e){System. out. println(" Access Denied");}catch 
                     //In case of exception we close the connection              socket .close ( );            System.out    .println ("Closed Connection from :"+IP);                  }        if (!socket.isBound() || !(socket instanceof DataInputStream)) {   DestroyableHelper.destroyAndClose(this, "Already Closed or already closed by user", server)}; 
              catch (Exception e) {}           try{server .close();}catch    // Close the Server socket when any exception occurs    
               finally{}             }         new SocketServerExample().start() ;   })        };      Console.log("Client Connected");})}); });