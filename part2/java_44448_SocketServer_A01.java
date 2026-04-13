import java.io.*;
import java.net.*;

public class java_44448_SocketServer_A01 {  
    public static void main(String args[]) throws Exception{    
        // Create a socket to communicate via network connections (TCP/IP). Socket is not thread safe, so we should use it in the same method where its used or create another one if needed. 
        
        ServerSocket server = new ServerSocket(6013);  
            System.out.println("Waiting for client on port: "+server.getLocalPort() +"...");    
            
           Socket socket=server.accept();    //Accepts incoming connection from a caller, blocking until connected  and returns associated sockect if accepted successfully otherwise it will throw an exception  
            System.out.println("Connected to client");      
               DataInputStream dis = new DataInputStream(socket.getInputStream());    
                String ClientMessage;    //Declare the variable for receiving string message from sender  through socket inbuilt inputstream reader,reading received data into a character stream and then closing it by using close() method of datainputStream class  
                 do{       
                     /*Read client's request*/         System.out.println("Waiting for Client Request");      String request= dis .readUTF();    //Reading string message from sender through socket reader  inputstream       and then closing it by using close() method of datainputStream class   }while(true);    
                   while((ClientMessage = (String)dis.readObject()) !=  null){          System.out.println("Received: " + ClientMessage ); //Reading the object received from sender  through socket reader       and then closing it by using close() method of datainputStream class    }         if(!(clientmessage .equalsIgnoreCase ("Exit"))) { Thread t = new NewThread ( client);  
t.start();}      else{ server.close(); }}while(true){serverSocket, socket=null; System..println("Closing down the both")}     try{}catch()  } catch(){}} //Catch block to handle any exceptions that might occur while running this program    if (socket !=  null) {  
                    socket .close ();} server.close(); }}//Close method for closing resources in a way where they can be reused by the OS and not held open over long periods of time     } //End catch block  to handle exceptions occurring while running this program    System..println("Closing down both");}}