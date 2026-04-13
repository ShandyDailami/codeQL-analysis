import java.io.*;
import java.net.*;

public class java_53214_SocketServer_A03 {  
    public static void main(String args[]) throws Exception{    
        ServerSocket welcomeSocket = new ServerSocket(6013);     
         System.out.println("Waiting for client on port 6013..." );      
          while (true){             
               Socket connectionSocket= welcomeSocket.accept();           
                System.out.println ("Connection established to " +connectionSocket);        try{            
                    OutputStream outToClient = connectionSocket.getOutputStream();      //Get output stream and writer for client           Write response back    
                   PrintWriter out = new PrintWriter(outToClient, true);        
                  BufferedReader inFromClient=new BufferedReader (                       new InputStreamReader  (connectionSocket.getInputStream()));               String userInput;             System.out.println("Waiting for input from client");            while ((userInput =inFromClient .readLine()) != null){                 //Read a line of text
                      if(null == userInput) { break;}                else{                     try  { Thread.sleep (10); } catch (Exception e ) {}                         System.out.println ("Received: " +userInput );                    out .println("Server response to :"+userInput)}                 //send a text back     
                      if( userInput == null) break;                }}catch  (IOException ex){                  try{connectionSocket.close();} catch (Exception e ) {} System.out.println ("Connection closed by " + connectionSocket);}}   }    finally {welcomeSocket.close();}}}