import java.io.*;
import java.net.*;
public class java_51123_SocketServer_A08 {  
    public static void main(String[] args) throws IOException{       
            ServerSocket welcomeSocket = new ServerSocket(6013);       //initialize server socket on port number 54289         
         while (true){             System.out.println("Waiting for client..." );           Socket connectionToClient=welcomeSocket.accept();                  BufferedReader inFromClient = new                 BufferedReader(new InputStreamReader                     (connectionToClient.getInputStream()));  String userInput;       
         while ((userInput=inFromClient .readLine()) != null){            System.out.println("Received from client: "+userInput);          //receive message                   }              connectionToClient.close();}}                 catch (IOException e) {e.printStackTrace()}    
    }}