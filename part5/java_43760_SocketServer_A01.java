import java.io.*;
import java.net.*;
  
public class java_43760_SocketServer_A01 { 
      
    public static void main(String[] args) throws Exception{     
        ServerSocket server = new ServerSocket(1234);         // Port number to use in client-server communication is fixed for simplicity, can be any available port.    
          
        System.out.println("Server Started with IP: " + server.getInetAddress().getHostAddress() +  ", and Port :"  + server.getPort());  
             
          while(true){  // Continue accepting client connections until we decide to shut it down   
                Socket socket = server.accept();       
                      
                System.out.println("Client Connected from IP: " + socket.getInetAddress().getHostAddress() );     
                         
                  Thread thread=new Thread(()->{ // Handling each client's request in a new thread             
                        try { 
                              DataInputStream dis = new DataInputStream(socket.getInputStream());  
                                  String message;   
                                      while((message=dis.readUTF())!=null){    
                                           System.out.println("Client: " + message);          // Echo back to client       
                                       } 
                                socket.close();     
                          } catch(IOException e) {        
                               e.printStackTrace();  
                            }   
                   });              
                      thread.start();      
            }             
     };            
};