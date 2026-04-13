import java.io.*;
import java.net.*;
import javax.sound.midi.*;
public class java_52487_SocketServer_A08 {  
    public static void main(String[] args) throws Exception{     
        ServerSocket server = new ServerSocket(2401); // port number for this example must be open and free (Port 2401 is a common one in TCP/IP world, you can use any available Port).  
         System.out.println("Waiting client connection...");    
        Socket socket = server.accept();   
          System.out.println("\nConnection Established with Client");       // Display message on console      Logger lgr  = Logger.getLogger(SocketServer.class);   char[] ch = new char[1024];  int bytes; DataInputStream dis=new     DataInputStream (socket.getInputStream()); BufferedReader br= 
         new    BufferedReader       (new InputStreamReader      ( socket . getInputStream())); PrintWriter pw  =                       // Creating writers on the streams   while((bytes =dis.read(ch))>0) { lgr          out     Logger  }                   System..close();}        });