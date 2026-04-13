import java.io.*;
import java.net.*;
public class java_47946_SocketServer_A03 {  
    public static void main(String[] args) throws Exception{    
        ServerSocket welcomeSocket = new ServerSocket(8189);      // Create a server socket on port number provided by the caller (default is 0, which means any available TCP/IP address and free local port).      
         System.out.println("Waiting for connection...");    
        Socket connectionSocket = welcomeSocket.accept();   
          System.out.println("\nConnection established from " + connectionSocket.getRemoteSocketAddress());      //Accept a client socket to server  
           DataInputStream inFromClient = new DataInputStream(connectionSocket.getInputStream());       // Get input stream and outputstream objects for communicating with the connected user  InputStream is used when reading data sent by Client, OutputStream uses when sending info from Server   
        String messageToServer;      double acceptedUserInput = 0 ;     boolean flag = true;   while(flag){          System.out.println("Enter your name:");       //Get a line of text input (reads console)         try{             InputStreamReader isr=new InputStreamReader(System.in);           BufferedReader br=  new BufferedReader(isr);     messageToServer =br.readLine();          System.out.println("Enter your password:");       // Get a line of text input from the user (also reads console)         try{             DataOutputStream outToClient =  new  DataOutputStream(connectionSocket .getOutputStream());           BufferedWriter bw=new   BufferedWriter(new OutputStreamWriter(connectionSocket.getOutputStream()));     messageFromUser = br.readLine();          if(!messageFromUser.equals("Exit")) {              //Password check             }