import java.io.*;
import java.net.*;
import java.util.*;

public class java_52647_SocketServer_A01 {  
    private static ArrayList<Socket> clients =new ArrayList<>(); //List to hold all connected sockets      
    
 public static void main(String[] args) throws IOException{ 
        ServerSocket server= new ServerSocket(8079);//Create a socket on port no. and listen for connections  
         System.out.println("Server started with IP: "+server.getInetAddress().getHostAddress());    
         
           while (true) {      //listen to multiple clients at the same time by using threads      
             Socket clientSocket = server.accept();   
              clients.add(clientSocket);   //Adding connected socket into list  for future use       
            System.out.println("Client IP: " + clientSocket.getInetAddress().getHostAddress()+" has been added");      
               Thread thread= new ClientThread (clientSocket,server );    //create a listener     which will get input from the socket and print it to console  for communication with clients     
            thread.start();   });        }//closing server after use or client disconnection is detected             try {         if(clients !=null)         
for (Socket s : clients){              SocketAcceptorService service = new SocketAcceptorService(s);                  //stop accepting connections  and close all socket in the list                Service.shutdown();} catch {} }     
    };   public static class ClientThread extends Thread{     String clientMessage;//data received from a specific connection (Client) are stored here        DataInputStream dis;         int pos =0 ;       //position of next byte to be read, starts at 1st Byte so initially set as zero.          try {     
dis= new DataInputStream(clientSocket.getInputStream());            while(( clientMessage =  dis .readUTF()) !=  null){//listening for message from the connected socket and print it on server side        System.out.println("Client says: " + clientMessage);     }         //after processing, we get here to close connection         
clientSocket.close();       clients.remove(this );}}} catch (IOException e) {e .printStackTrace () ;}}; 1    public static class SocketAcceptorService extends Thread{        private boolean running = true;   try             while((running))         {}catch{}finally            this.stop()