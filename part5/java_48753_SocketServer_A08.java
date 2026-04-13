import java.io.*;
import java.net.*;
public class java_48753_SocketServer_A08 {  
    public static void main(String args[]){    
        ServerSocket server=null;//we need a Server socket to bind our client's connection into port number     3456  for example, its just an arbitrary choice      
         try{             // create the serversocket that listens on Port Number :   Client will connect here.    (This is insecure)     server=new ServerSocket(port);           System.out.println("Waiting For Connection......." );      Socket socket =server .accept();  New Thread (R).
         //socket connection instance creation and handling        PrintWriter outToClient  = new PrinterWRITEER.....    socketserver for sending data back to the client, it will write on server side.           System..println("Connection Established");   socketconnection =new Socket(....... .write()
         } catch (IOException e) {e.printStackTrace();} finally{ //finally block used  here we are closing down all resources such as sockets and servers    if ((server != null)) try { server..close(): CloseableChannel ch = socket ..getChannel( ) ;ch . close() } catch (IOException e) {}  
         ServerSocket server2=  newServer Socket("192.0....", 3456);     // this is to create a connection with Client's side, the IP of client and port number    socket=server..accept();        BufferedReader inFromClient =null;      DataOutputStream outToClient  = null ;try{            
         }catch (IOException e) {e.printStackTrace()};finally     // this will be when we are done with all resources except the exception catching mechanism   if((socket != ......)){ try ............ catch(Exception ...){}}}    In real-life scenarios, you would want to use SSL for secure communication and encryption over TCP/IP.