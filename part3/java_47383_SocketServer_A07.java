import java.io.*;
import java.net.*;
    
public class java_47383_SocketServer_A07 {  
    public static void main(String[] args) throws IOException{      
        ServerSocket welcomeSocket = new ServerSocket(1234);          
         while (true){             
            Socket connectionSocket = welcomeSocket.accept();            
                try 
                    //try-catch block for socket communication   
                 {  
                     System.out.println("Just connected to " + connectionSocket.getRemoteSocketAddress());    
                      DataInputStream inFromClient =  new DataInputStream(connectionSocket.getInputStream());     
                          String clientMessage = inFromClient .readUTF();                 
                            //check if passwords match - here we'll just check for the string 'password':   
                        	if (clientMessage.equals("password")) {                             System.out.println ("Authentication successful");     } else  {                           println( "Wrong Password!");}                               connectionSocket .close();                     }}catch (IOException e){e.printStackTrace()};                }}         //closes welcome socket