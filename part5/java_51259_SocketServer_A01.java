import java.io.*;  // Importing InputStream Class from java.io package  
import java.net.*;  //Import necessary classes for network programming   
public class java_51259_SocketServer_A01 {     #defining a public server-side socket program     
       private static final String SERVER_STATE = "Your Server's State";        
        int port = 6001;              #declaration of the integer type variable to hold my localport number.  
  //Initializing Socket and accepting client requests in a loop (server is always listening)      public static void main(String[] args){    System.out.println("Waiting for incoming connections...");       try{        ServerSocket server=new ServerSocket();         socket = server.accept() ;  
  //here we are creating input stream and output streams to handle communication with the client     InputStream inFromClient;      OutputStream outToClient;    DataInputStream fromUser;           new BufferedReader(                      (new InputStreamReader                          );          int i = 0;}catch         java.io .IOException e {e  
  //handling exceptions} }            while ((i = reader.read()) != -1) {}     try{      inFromClient  = socket.getInputStream();              outToclient   =socket. getOutputStream() ;       fromUser    = new DataInputStream(infromCLient);             String clientMessage;  
  //user will provide a message to be send back, and then they can use the same mechanism for input          while ((c= inFromClient .read()) !=  -1) { Client Message = reader. readline();     if ("exit".equals(clientmessage)) break;}      outToUser   .println("You have exited."); socket.close() }catch (IOException e){e   
  //handling exceptions} }}