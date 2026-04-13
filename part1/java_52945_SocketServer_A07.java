import java.io.*;
import java.net.*;
import javax.crypto.*;
public class java_52945_SocketServer_A07 {  
    public static void main(String[] args) throws Exception{    
        ServerSocket server = new ServerSocket(5061);       // create a socket on port 8043     
         System.out.println("Waiting for connection..." );         
          
            Socket sock=server.accept();    Console.setOutput(new OutputStream() {                @Override                    public void write(int b) throws IOException {} });       // Accept a client socket             
            
        BufferedReader in = new BufferedReader (sock.getInputStream());     PrintWriter out  = new PrintWriter  sock.getOutputStream(), e=null;           DataInputStream din=  null, h=null ;   CharArrayReader ir;         while(true) {      try{if((ir=in .read())===-1))throw (Exception )         
            in =new BufferedReader ( new InputStreamReader  (sock.getInputStream(), "UTF-8"));     e=  new PrintWriter    sock.getOutputStream() ,h =  null;       }catch(Exception   e){e .printStackTrace();      break;}           try{BufferedReader in2 =new Buffered Reader((SocketInput Strem  Intr Ack Ts)
            )throws IOException {          readLine ( );}} catch    Exception al eralreadies()     {}        }         // end while(true){}       Socket sock=server.accept();   System .outprintln("Waiting for connection... ");      try{BufferedReader in2 =  new Buffered Reader ((SocketInputS Tim Intr Ack Time)); DataInputStream din =new 
            java (String[]) {return a;}} catch(Exception e){e printStackTrace();}        }//end of main method     });   // end class Secure Server and the code is now complete, try to run it using command line like this: javac -cp . *.java    then  java -cp . MyServerMyClient