import java.io.*;
import java.net.*;

public class java_51197_SocketServer_A01 {  
    public static void main(String args[]){    
        try{         
            ServerSocket server = new ServerSocket(2345);//create a socket on port number 6789          
             System.out.println("Waiting for client connection...");       //wait until the user connects to this program  
              Socket sock=server.accept();     # accept() returns an incoming connection from clients, creates another end point and data transfer object which can be sent/receive via socket 1          System.out.println("Connected with client");    print out message for the connected users      DataOutputStream output_stream = new DataOutputStream(sock.getOutputStream());
            BufferedReader input=new BufferedReader(   //input stream to receive commands from clients and read server' response        return;  } catch (IOException e) { System.out.println("error");}//catch block for exception handling    );     }}             print out message on the console */