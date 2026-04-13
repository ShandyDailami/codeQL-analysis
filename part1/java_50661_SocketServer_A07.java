import java.io.*;
import java.net.*;

public class java_50661_SocketServer_A07 {  
    public static void main(String[] args) throws Exception{       
         Socket socket = null;          //Socket object for client/server communication           
         ServerSocket server=null ;      //socket listening on the port                    
         DataInputStream dis =  null;     //input stream from a connected user                   
         ObjectOutputStream oos=  null;   //outputstream to send data back via socket          
        try{                
                int clientPort = Integer.parseInt(args[0]);  /* getting first command line parameter */   
             server=new ServerSocket(clientPort);          //creating a new socketserver on the specified port                     
            System.out.println("Server started at "+server.getLocalSocketAddress());     
              while(true) {                
                     socket = server.accept();                /* waiting for connection */   
                    dis=new DataInputStream(socket.getInputStream());  //input stream from a connected user                     
                   oos=  new ObjectOutputStream(socket.getOutputStream());   //outputstream to send data back via socketserver         
                  String msg = null;                       
                 while((msg  =dis.readUTF()) !=null){               /* read client message */   
                            System.out.println("Received :"+msg);       #received the string from a user            
                           oos .writeUTF( "Server says: Hello, Client!" );  //sending back an echo to connected clients          }                  });                   while() loop is always running            socket connection closed abruptly after read or write operation exception.                    serverSocket was not properly shutdown */              if (socket != null) {
                                                                                 try{     /* closing resources on error - best practice for multi-threading programming    socketserver, datainputstream and dataoutputstream have their own close method that can be called to cleanup when necessary.*/                     socket.close(); oos .close(); dis.close();}catch(Exception e){}}}}}
                   } catch (IOException i) {i.printStackTrace(); return;}}, 0);     // end of the program if a communication exception occurs    println("Server stopped"); serverSocket was not properly shutdown */              };};          try{server_maintainer().stop(null, null)}catch(Exception e){}}finally {}
}