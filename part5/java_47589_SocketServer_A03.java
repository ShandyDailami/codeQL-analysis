import java.io.*;
import java.net.*;
  
public class java_47589_SocketServer_A03 {    
    public static void main(String[] args) throws IOException{         
        ServerSocket server = new ServerSocket(54321);//port number should be open and available           
           System.out.println("Waiting for client on port " +server.getLocalPort()+"..." );               
         Socket socket=null;            
               try{              while((socket=server.accept()) !=  null){                
                     System.out.println("\nAccepted new connection from: " 
                     + socket.getRemoteSocketAddress());                 
                          DataInputStream dis =new    
                       DataInputStream(socket.getInputStream());            //read request                   
                           String message=dis.readUTF();              if("exit".equalsIgnoreCase   (message)) {break;}                System.out.println("\nServer received: " +    message);  }          finally{           socket.close();}}               catch(Exception e){                   ExceptionDispatcher.forward(e,null );}           
       ServerSocket serverobject=new     Socket("127.0.0.1",54321).getLocalPort()==server    .getLocalPort()? (ServerSocket)server: new StringBuffer().append("/n").append   ("Error accepting client on port " ).concat(Integer.toString((socket = serverobject)).concat(" is either not a valid port number or the" 
      +      "'Try again later."));}                  }                    catch    (IOException e){                   ExceptionDispatcher .forward     (? IOException e);}}              });