import java.io.*;
  import java.net;
    
public class java_44647_SocketServer_A03 {     
       public static void main(String[] args) throws IOException{         
             // Create a server socket on port number 12345               
           ServerSocket ss = new ServerSocket(12345);              System.out .println("Server Started..");                
            while (true){                  try {                      Socket sock = ss.accept();                     DataInputStream dis=new DataInputStream(sock.getInputStream());                   // Accept a client connection and establish data input stream                    String messageFromClient;                       do{                          System .out .println("Waiting for Client..");                             Thread.sleep(10);                           }while (true);                     
              try {                              PrintWriter pw=new PrintWriter(sock.getOutputStream(), true );                     // Establish data output stream                    String messageToClient;                       do{                          System .out .println("Waiting for Data..");                             Thread.sleep(10);                           }while (true) ;              
                   try {                              int c = dis.read();                         if ((char)c=='q') break;}                 // Check the 'Q'-character sent by client to quit                    pw .println("Echo: " + messageFromClient );                     ssocketException e){ System  .out   ("Error"+e);}             } catch (IOException ex ){ex.printStackTrace();}}