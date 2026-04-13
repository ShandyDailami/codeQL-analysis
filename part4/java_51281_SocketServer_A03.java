import java.io.*;
import java.net.*;

public class java_51281_SocketServer_A03 {
    public static void main(String[] args) throws Exception{
        ServerSocket server = new ServerSocket(8102); // Listening port for the socket connection  
        
        while (true){ 
            System.out.println("Waiting to connect ...");         
            
           Socket sock =server.accept();    ///Accepts incoming request from client, returns a connected stream over TCP/IP link between two computers on network     
               
               //Creates InputStream and Outputstream for reading the data sent by Client  & writing back to server using socket        
            DataInputStream dis=new DataInputStream( sock.getInputStream());   ///Create input streams       
              PrintWriter out = new PrintWriter (sock.getOutputStream(),true);     //Creates output stream         
           System.out.println("Connected with Client"); 
               
               String request;      # Request received from the client        
            while ((request=dis.readUTF()) != null){    ///Read a line of text sent by user, and then send it back to server if not quit    
                 System.out.println("Received: " + request);          //Prints out what was read  
                  String response = validateRequest(request) ? "Command accepted" :  "Insecure Command";    ///Checking the validation of command, based on whether it is secure or not     
                if(!response.equalsIgnoreCase("Secure Request")){       ##If security issue found print out error message and break loop    
                    System.out.println( response );                      //Prints back to client        
                     continue;                                   ///Break the current iteration, go ahead for next request     
                 }           
                else {                                             #Else if it's safe command then send this data       
                   out.writeUTF("Secure Request");                  ///Send secure response    by server  
                    System.out.println ("Sent: " +response );       //Print sent back to client     return;  }      });         sock .close();          }}            catch (IOException e){}           printStackTrace(e);              break;}        };}}}}}`end of code snippet