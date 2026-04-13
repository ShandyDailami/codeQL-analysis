import java.io.*;
import java.net.*;
  
public class java_52877_SocketServer_A03 {    
    public static void main(String[] args) throws Exception{       
            ServerSocket server = new ServerSocket (8091);           //Create a socket on port number '8091' 
             System.out.println ("Waiting for client...");  
                  
          Socket sock=server.accept();       printWriter =  new PrintWriter(sock.getOutputStream(),true);            while ( true ) {      try{     //Get input and show to screen                     Scanner scan =new  Scanner(sock.getInputStream());                    String clientInput;  
             System.out.println ("Waiting for command..." );       char[] ch= new char[256];    int i = 0 ;      do {if (scan.hasNextLine())                //read line from the stream  scan .nextBytes()==null;}     while(true); }catch(){sockclose();}             System.out.println("Connection closed by client");                 sock.close();break;}}}