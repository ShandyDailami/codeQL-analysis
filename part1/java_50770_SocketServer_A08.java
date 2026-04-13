import java.io.*;
import java.net.*;
import javax.crypto.*;
public class java_50770_SocketServer_A08 {  
    public static void main(String[] args){ 
        try{     
            ServerSocket s=new ServerSocket();     //Creates a server socket on port number '54321' (change as needed)      
             while(!s.isClosed()){               #Server waits for client connections until closed by the clients  
                Socket incoming = new Socket(InetAddress.getLocalHost(), 54321);     //Accept a connection from another socket   
                 System.out.println("Connection established with "+incoming.getRemoteSocketAddress());      #Prints client IP and port number  
                DataInputStream dis=new DataInputStream( incoming .getInputStream ());             #Get input stream for reading data packets 
                  BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));     #Provides buffering character read     
                   String message;    //Reads in the string from standard console  
                while(!(message=br.readLine()).equals("exit")){       #Continuously reads incoming data until "Exit" command given  by user (or till connection closed)    
                    byte[] buffer = new byte[1024];                     //Buffer for receiving bytes   
                   int bytesRead;                                      #Number of received bytes  
                while((bytesRead=dis.read(buffer))!=-1){              #Reading from the socket in a loop until all data is read  or connection closed by client    
                       System.out.println("Received: "+ new String ( buffer,0 , bytesRead));           //Prints received message  
                      }                                                  #End of while(bytesread!=-1)   
                }                                                                            # End receiving data from user  and closing connection with client    
             s.close();          /* Closing the Server Socket */     
        }}catch (IOException e){ System.out.println("Error: "+e);}                    //Catching any exceptions that might be thrown by IO operations   }    catch(SocketException se ) { println ("Server socket is closed");     break;}}