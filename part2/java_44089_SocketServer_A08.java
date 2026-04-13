import java.io.*;
import java.net.*;

public class java_44089_SocketServer_A08 {  
    public static void main(String args[]) throws Exception{    
        ServerSocket server = new ServerSocket(8091); //Assuming port number is available and accessible for your environment settings 
         System.out.println("Waiting for client on port " +server.getLocalPort()+"...");  
          Socket socket=null;    
        try{            
            while (true) {             
                //Accepts incoming connection requests from clients   
               socket = server.accept();           System.out.println("Just connected to port " +socket.getLocalPort());        
                 DataInputStream dis=new DataInputStream(socket.getInputStream());       
                  PrintWriter pw=  new  PrintWriter (socket.getOutputStream(),true);         
                   String clientMsg;    //reads in string from the socket input stream  
                do{           System.out.println("Waiting for Message");            
                    try {clientMsg= dis.readUTF();}        catch(IOException e){e.printStackTrace();continue;}      
                         if (checksumValidation(clientMsg)) continue;         //If the received message is valid, then ignore it otherwise break out of loop     } while(!true);               pw.println("Message Received");    System.out.println ("Just wrote " + clientMsg+" to port ");     
            }}catch (IOException e){System.err.println(e.getMessage());}          server.close();   //closes the socket connection     }//end of while loop       catch{}             if(socket != null) {try{socket.close();}}finally {}  at end        System.out . println("Closing down...");