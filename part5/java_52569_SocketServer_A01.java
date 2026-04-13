import java.io.*;
import java.net.*;
public class java_52569_SocketServer_A01 {    
    public static void main(String args[]) throws Exception{        
        ServerSocket welcomeSocket = new ServerSocket(6013);      
          while (true){            
            Socket connectionSocket = welcomeSocket.accept();           System.out.println("Just connected to " + connectionSocket.getRemoteSocketAddress());               try {                
              OutputStream outToClient = connectionSocket.getOutputStream();                PrintWriter out = new PrintWriter(outToClient, true);                   String clientMessage;             while ((clientMessage = br.readLine()) != null){                       if (fileExistsAndWritesOk(clientMessage)) break;}                
            } catch (IOException e) {               System.err.println("IO exception occured when talking to " + connectionSocket.getRemoteSocketAddress());           }}       welcomeSocket.close();  //closes the socket and ends program                try{Thread.sleep(10);}catch(Exception exc){exc.printStackTrace();}}