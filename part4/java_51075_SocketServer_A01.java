import java.io.*;  // Import necessary classes  
import java.net.*;   
    
public class java_51075_SocketServer_A01 {     
        public static void main(String args[]) throws Exception{      
            ServerSocket server = new ServerSocket(8976);        
             while (true){              System.out.println("Waiting for client connection......");  // Wait until a Client is connected   Socket socket=server.accept();           try {               PrintWriter out = 
new PrintWriter(socket.getOutputStream(), true);    if (!args[0].equals("-noclient")){          System.out.println("\nConnected to client"); }         BufferedReader in = new BufferedReader   (     new InputStreamReader  ( socket . getInputStream()));             String inputLine;             
while ((inputLine=in.readLine()) != null){               out.println(inputLine);                     System.out.println("\nReceived :" +inputLine );}          } catch (IOException e) {                  //TODO Auto-generated   catching block for handling socket connection exceptions  try
close();                                  serverSocket.close() ;                if (!args[0].equals(" -server")) out . close ()                       System.out.println ("Client Disconnected");       }}                    finally{                     }               SocketServer.this . close ();        ServerSocket s=null;}}   // Closing the connection