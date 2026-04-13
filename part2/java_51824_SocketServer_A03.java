import java.io.*;  // Import required Java API features (BufferedReader and PrintWriter)   
   import java.net.*;    
public class java_51824_SocketServer_A03 {     
 public static void main(String[] args){      
 try{             
// Create a server socket at port number PORT_NUMBER on the local machine              
 ServerSocket welcomeSock = new ServerSocket(PORT_NUMBER);            
 while (true)  // Beginning of 'server' code.    2345678910    -> This is just a placeholder, replace it with your chosen port number      
 {     
 Socket connectionSoCKet= welcomeSock.accept();          
 BufferedReader inFromClient = new BufferedReader(              // Create input stream to receive data from client              
  new InputStreamReader (connectionSocket.getInputStream()));               
 DataOutputStream outToClient  =new DataOutputStream(             Connection_socket . getOutPutstream());                 PrintWriter writer=null;    for        (;;)      {                  String line = inFromclient reader, readLine(); if ("exit".equals(line))  break;}                    } catch (IOException e){e.printStackTrace()}