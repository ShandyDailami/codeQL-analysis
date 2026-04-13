import java.io.*;
import java.net.*;

public class java_52564_SocketServer_A07 {  
    public static void main(String args[]) throws Exception{ 
        ServerSocket server = new ServerSocket(6013); // listening port is set to a common number in internet, e.g., '5421' by convention    
        
        while (true){            
            Socket sock=server.accept();  
             
               DataInputStream dis  =new  DataInputStream(sock.getInputStream());    //input stream from the client          
                BufferedReader br = new BufferedReader(                     //read input data line by-line        
                    new InputStreamReader (sock.getInputStream()));    
                 String str;         
                  while ((str=br.readLine()) != null){                      /// read a string from the client          
                   System.out.println("Client says: " + str);                // print to console         }                        try {  Socket sock = new Socket(host, port);    DataOutputStream dos  =sock.getOutputStream();              String say="Hello Client";   byte [] msgout=  say.getBytes();            
                   dos .writeUTF (say );                     ///send a string to the client       } catch  Exception e { println ("Exception caught " +e ) ;}                  finally{ if(sock !=null) sock.close();}}    // end try and close socket     });}}}`;