import java.io.*;
import java.net.*;

public class java_52875_SocketServer_A01 {  
    public static void main(String[] args) throws IOException{    
        ServerSocket server = new ServerSocket();       // step a: Create the socket on port 12345 (Change as per your requirements).     
        
        System.out.println("Waiting for client to connect...");   // print statement will help identify if code is running correctly or not   
                                                                                                   
        Socket sock = server.accept();       // step b: Accept a connection from the socket, this call blocks and waits until it receives an incoming request 
                                                   (blocking).    
        
        System.out.println("Client connected!");   // print statement will confirm that client has been successfully established   
                                                                                                   
       DataInputStream dis = new DataInputStream(sock.getInputStream());      // step c: Create a data input stream, this allows us to read the incoming request from 
                                                         socket (non-blocking).     Socket programming is all about communication between server and client  
        
        String messageFromClient =  dis.readUTF();       // Step d & e : Read an outgoing string using a DataInputStream   
                                                                                                   
        System.out.println("Message from Client: " +messageFromClient);  Print statement will confirm that the received request has been successfully read by client  
        
                                                   sock.close();      Close connection after use (step f)            .getOutputStream());          // step d : Send a response back to socket, this call is non-blocking and it writes data out into network  packet stream for sending over the wire     }    catch(IOException e){  
                                                                                                    System.out.println("Exception occured in I/O operations: "+e);      // Catch exception if any occurs during input or output operation, then print that error message                      }}