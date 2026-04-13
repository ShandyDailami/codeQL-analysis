import java.io.*;
import java.net.*;
import java.util.HashMap;
public class java_43126_SocketServer_A07 {
    public static HashMap<String, String> userdb = new HashMap<>(); //sample users database (not secure)
    
        /* sample data */ 
       static{  
           userdb.put("user1", "password");  
         }     
            
            private Socket socket;   
               public void startServer(int port){         
                   try {               
                        // Create a server socket and wait for client connection                 
                         this.socket = new Socket("localhost" ,port); 
                          System.out.println ("Client connected to the Server");  
                           InputStream is=this.socket.getInputStream();   
                               DataInputStream dis=  new DataInputStream(is);     // Read data from client          
                                  String userName,passWord;         int portno, clientsocket;        boolean b=true ;      char ch ='a'; 
                                         while (b){          try{                   if ((ch=dis.readChar()) != 0) {                    System.out.print(new String ("Received: " + new Character (ch).toString()));              } else   break;                  // If data is not received, end the connection        }} catch  Exception e     {}   
                                           while((passWord=dis.readLine()).length()>0) {                     System.out.println("Password :"+ passWord);                        if (userName==null || userdb.get(userName).equalsIgnoreCase(passWord))   // Authenticate the client        }  catch (IOException e){e.printStackTrace();} });     
            }}          public void stopServer() {              try{                  this.socket.close();                 System.out.println ("Closed connection with Client");           }catch (Exception ex) {}    finally{}}}     // Main method to initiate the server   static  int port =2345;     
                                                             public static void main(String args[]){              SocketServer svr=new SocketServer();               svr.startServer((port));           }}// The code is not perfect but it serves a purpose only for learning purposes and should be kept as minimalistic in nature until secure communication protocols are developed fully or data encryption methods can't provide the absolute safety needed to connect with client on given port (A07_AuthFailure).