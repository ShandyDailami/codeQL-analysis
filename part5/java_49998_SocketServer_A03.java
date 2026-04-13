import java.io.*;
import java.net.*;

public class java_49998_SocketServer_A03 {   //S02_Reflection is not a part of your requirement but included here to make the example more realistic 
    public static void main(String[] args) throws Exception{           /* S13 Injection - Not allowed */    
        ServerSocket server = new ServerSocket();                      /* BAD Practical way due SecurityIssues A02_BrokenEncoding, No use of External libraries for SSL and Usage of builtin classes (e.g., BufferedReader/Writer)*/  
        
       // Step 1: Create the socket server using a standard port number like this one(80). Use an alternative if necessary in production code; you can always change it later by calling bind() method with your choice of another integer, e.g new ServerSocket (9456) - for example
        try {                                                       /* CWE123: Inappropriate Exception Handling */  server =new   ServerSocket(80); // create a socket at this port number and accept connections on it*/        
            System.out .println ("Waiting Connection from client..." + "\n");// Wait for connection request (Blocked by Socket Security - not recommended due to lack of SSL/TLS)     } catch Exception e { println("Exception "+e); return;   // handle exception if necessary, we are doing bad practice here 
            while(true){                                                    /* CWE340: Broken Communication Channel (BrokenChannel communication may be disrupted at this point due to the following reasons - not recommended) */           Socket sock = server.accept();//Accepting client connection from socket    //Here, we are allowing blocking call without any SSL/TLS and no security measures for real world usage
            DataInputStream dis=new   DataInputStream(sock .getInputStream ()); /* CWE123: Inappropriate Exception Handling */  System.out      .println("Connection from client-side IP:" + sock     .getRemoteSocketAddress().toString()+"\n");         //Get the Client side'S Address and print it
             String msg= dis..readUTF();/* S03_BufferExhaustion - not allowed as we are using buffered input stream */  System.out      ..println ("Message from client: " +     msg+ "\n" );          // Get the message received by Client & display*/       
             sock .close ();                                               /* CWE401 : Unauthorized Cleartext Transmission of Sensitive Information and No use SSL/TLS */    }   catch(IOException e){ System.out  ..println("Exception "+e ); return; // handle exception if necessary}
        }}