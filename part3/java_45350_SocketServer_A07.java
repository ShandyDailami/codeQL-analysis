import java.io.*;
import java.net.*;
public class java_45350_SocketServer_A07 {  
    public static void main(String args[]) throws Exception{        
        ServerSocket server = new ServerSocket(4243); // port number is arbitrary, change as per requirement 
          
        while (true){            
            Socket socketConnection = server.accept();             
              
                DataInputStream dis=new DataInputStream(socketConnection.getInputStream());                
                  String messageReceived;                        
                    
                    do{                         
                      //reading the client's input         
                       try { 
                            System.out.println("Server waiting for a Message from Client...");  
                             messageReceived = dis.readUTF();   
                              if (messageReceived == null) throw new Exception ("Null string received");                
                           } catch(Exception e){                    
                               socketConnection.close();  //closes the connection and free up resources          
                           return;                       
                          }  
                       System.out.println("Client: " + messageReceived);    
                      if (messageReceived==null) throw new Exception ("Null string received");                   
                     }while(true );             
                socketConnection.close();      //closes the connection and free up resources  });                
            }}   catch (Exception e){    System.out.println("Error: " +e);     return;}}