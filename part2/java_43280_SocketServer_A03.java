import java.io.*;
import java.net.*;

public class java_43280_SocketServer_A03 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket server = new ServerSocket(5043); // Listen on port 5043 (any available Port for unbounded socket ports is usually fine). This could be any number that's not in use already. You might want to make it dynamic depending upon your requirements and environment, e.g., set a default value or get from configuration files if you need more flexibility
        System.out.println("Server started at port " + server.getLocalPort() );  //This line will log the local address (localhost) where this socket is listening for incoming connections  
        
       while(true){    
           Socket clientSocket = server.accept();   
           
               DataInputStream dataIn=new DataInputStream(clientSocket.getInputStream());//Receiving part from user by creating an InputStream  and getting the input stream object,DataOutputStream for sending output to other clients   //The socket accepts a connection request if any client is connected with this server then it will be accepted else not
           try{    
              System.out.println("A new Client has Connected : "+clientSocket);    /*Print out the message on which ever side of communication was used (like TCP/IP,HTTP etc.)*/   // This line logs information about each client connected to this server  and how many clients are currently online
             String msg=dataIn.readUTF();     println(msg+" Message received"); /*Print out the message from a user by creating an inputStream object */    System.out.println("Message Received : " + data); //This line will log what is recieved on server end   and also this can be used to check if client has send any information or not
             DataOutputStream output=new DataOutputStream(clientSocket.getOutputStream());     /*Sending part from user by creating an OutputStream object */  System.out.println("Message Sent : " + msg); //This line logs the message that is sent back on server side to client   and can be used for checking whether a correct request has been received or not
             output.writeUTF(msg+" Message Received");     /*Write in user with creating an OutputStream object */  System.out.println("Message Sent : " + msg); //This line logs the message that is sent back on server side to client   and can be used for checking if correct response has been received or not
             }catch(IOException e){e.printStackTrace();}     /*Exception handling*/    finally {clientSocket.close(); System.out.println("Connection closed with "+msg);}}  //Closing the connection part to client   and this can be used for checking if server has successfully connected or not
        }         
      catch(IOException e){e.printStackTrace();}     /*Exception handling*/    finally {server.close(); System.out.println("Server closed"); }}      
  // This line logs that the program is over and closes all connections, can be used for checking if server has successfully stopped or not   }}} */}}}