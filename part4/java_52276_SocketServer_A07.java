import java.io.*;
import java.net.*;

public class java_52276_SocketServer_A07 {  
    public static void main(String args[]) throws Exception{ 
        ServerSocket welcomeSocket = new ServerSocket(8181);      
          while (true){            
                Socket connectionSocket = welcomeSocket.accept();              System.out.println("Accepting a client on port " +connectionSocket );                    
                    DataInputStream inFromClient=new  DataInputStream(connectionSocket .getInputStream());            String userInput;                         try{    //Read from the socket        		  	userInput =  inFromClient.readUTF();          System.out.println("Received: $"+ userInput);                }catch (IOException e){
                        connectionSocket.close();  println(e.getMessage());             continue;}           Connection conn = new ConnectionImpl(connectionSocket, clientAddr().getHostAddress() + ":" +  Integer.toString((new SecureRandom()).nextInt()));         try{   //Send to the socket          DataOutputStream outToClient=conn . getOutput  Stream();     if (userInput != null) {outToClient   
                   ClientfirstRequest clientrequest = new Gson().fromJson( userinput,      com.google..clientFirstReqst); println("Invalid Credentials");continue; }          outTOCLIENT .println ("Server: Hello Client " +userInput );       conn  close();        }}            
    private static InetAddress clientAddr(){     if (args.length != 1) throw new java..ArgumentException(   ..); return      InetAdressesion ipn = IPNetAdapter .parseLiteral("2038-DECIMAL" + args[ 0 ]).getInetaddress();return ipn;}}