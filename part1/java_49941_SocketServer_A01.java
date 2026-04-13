import java.io.*;
import java.net.*;

public class java_49941_SocketServer_A01 {  
    public static void main(String[] args) throws IOException{      
        ServerSocket server = new ServerSocket(1234); // port number can be any available unbound TCP/IP port     
         System.out.println("Waiting for client on port: " +server.getLocalPort()+"..." );  
 
          Socket socket = null;   
        try {    
            while (true) {             
                // accept a new connection from the clients' side     
               socket= server.accept();           System.out.println("Just connected to port: " +socket.getPort());  
 
                  OutputStream outToClient = socket.getOutputStream();     Writer writer;   
                    BufferedWriter bw  = new BufferedWriter(new OutputStreamWriter(outToClient));      //write here, e.g., client's ip or your own message       System.out.println("Just connected to port: " +socket.getPort());  
                   String answer ="Connected";     Writer writer;    BufferedWriter bw  = new 
                  OutputStream( socket.getOutputStream() );      //write here, e.g., client's ip or your own message       System.out.println("Just connected to port: " +socket.getPort());   }            catch (IOException ex) { ServerSocketExample.this.closeIt(server); 
                  socket = null;                    return;}     });              // closing connection in case of an exception, here is a simple way       System.out.println("Closed connections"); server.close();}      finally{    if(socket !=null) {try {Thread.sleep(100); }catch (Exception ex){ 
                  socket = null;                    return;}     ServerSocketExample e =  new   SocketServerExample() ;       System .out . println ("Starting server on port: " +e.server.getLocalPort());    //start the connection here, for example you want to keep trying if fail with a delay
                  }catch (Exception ex){      return;}     ServerSocket socket = null; try{Thread  sleep(10);} catch (Interrupted Exception e) {return ;}}        finally{}   }}//end of main method       public void closeIt(ServerSocket server ) throws IOException    //method for closing connection at shutdown.