import java.io.*;
import java.net.*;
    
public class java_50913_SocketServer_A03 {     
    public static void main(String[] args) throws IOException{         
        ServerSocket server = new ServerSocket(5000); //define port number to listen on        
          
        while (true){             
            Socket socketConnected = server.accept();   //wait for client connection              
                   
             System.out.println("New Client Connected!"); 
                       
          try{                      
                DataInputStream inStream =  new DataInputStream(socketConnected.getInputStream());                  
                  String message=inStream.readUTF();     
                 printMessage(message, socketConnected);   //print out received client's data                    
             }catch (Exception e){  System.out.println("Error Occurred: "+e );}               
        server.close();    }}}    
      
 public static void printMessage(String message ,Socket connection) {         
           try{               //print received client's data                  
             DataOutputStream outStream = new DataOutputStream(connection.getOutputStream());                   
              String reply="Hello Client, Your Message has been Received: "+message;   
                System.out.println("Client Says :  " +reply );                     //echo back to client          
               }catch (Exception e){   printErrorMessage(e);}                 
      }}            private static void printErrorMessage( Exception error ){             try { throw error;} catch (Throwable ignore) {}    System.out.println("An Error Occurred"+error );}}  });