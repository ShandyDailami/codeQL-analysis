import java.io.*;
import java.net.*;
public class java_48292_SocketServer_A03 {    
    public static void main(String[] args) throws IOException{        
        ServerSocket server = new ServerSocket(6013);  // Creating a socket on port no : 8754, but better to use an out-of-the-box random one.  
       System.out.println("Server Started... waiting for connections");    try {    
        Socket client = server.accept();          
         System.out.println(client.getRemoteSocketAddress() + "connected.");             DataInputStream dis= new  DataInputStream (client.getInputStream());            BufferedReader br =  new BufferedReader(new InputStreamReader(client.getInputStream()));   // Reading the message sent by client    String data =dis .readUTF();     
        System.out.println("Message Received : " +data);                   if ("Exit".equalsIgnoreCase (data)) {            server.close();                 } else  {"Hello,"+data, Server: Thank you for connecting};     // Sending back a message to client   DataOutputStream dos=new DataOutputStream(client .getOutputStream());      
        String reply;    do{reply = br.readLine (); if (!reply.equals("Exit")) {  "Hello,"+data, Server: Thank you for connecting". equalsIgnoreCase } ;}while(!reply.equals ("exit"));   // server waits until client sends ' exit '.
        dos . writeUTF( reply ); close();    System.out.println("\n Disconnected from Client");             
       } catch (IOException e) {  println("Error occured while reading/writing to the stream.");} finally{server.close();}}     // Ensuring server and client socket is closed no matter what happened before this block of code gets executed   System . outprintln ("Server Stopped...bye bye!");
    }