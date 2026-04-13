import java.io.*;
import java.net.*;
  
public class java_47302_SocketServer_A01 {   
      public static void main(String[] args) throws IOException{       
           ServerSocket server = new ServerSocket(6032);  // specify port number to run the socket on, different ports should not be used for multiple services    
          while (true){           
               Socket sock=server.accept();     
                BufferedReader inSock=new BufferedReader(                   
                        new InputStreamReader(sock.getInputStream()));                 // read from client socket                 
                       String strInput; 
                      do {                           
                         try{                           if((strInput =inSock .readLine())==null) break;}                             catch (IOException e){e.printStackTrace();}                    
                          System.out.println("Client says: " + strInput);                    // echo back to client                                 
                       }while(true);              while (!sock.isClosed() && sock instanceof ServerSocket ) try{                 server.close();  break;} catch (IOException e){e.printStackTrace();}        });             }}