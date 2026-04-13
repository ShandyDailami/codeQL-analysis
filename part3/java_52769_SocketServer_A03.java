import java.io.*;
import java.net.*;

public class java_52769_SocketServer_A03 {  
    public static void main(String args[]) throws Exception{    
        ServerSocket server = new ServerSocket();     
        
        // Bind the port to socket using below code  (you can use any available Port).          
        String PORT_NUMBER="6012";  
                
       try {           
             System.out.println("Waiting for client on: "+PORT_NUMBER);     
              server = new ServerSocket(Integer.parseInt(PORT_NUMBER));    // create a socket  and bind it to PORT number       
                while (true)     {      
                    Socket sock=server.accept();             System.out.println("Connection established with: " +sock.getRemoteSocketAddress());             
                     new EchoThread(sock).start();   // handle client communication in a separate thread   
                  }           
               } finally {       server.close();     }  }        public class EchoThread extends Thread      { private Socket sock;          public java_52769_SocketServer_A03(Socket s) {         super("EchoServer");             this .sock=s;} @Override   public void run()                  //read from the socket and write back to client           
               try{                   BufferedReader in = new BufferedReader(new InputStreamReader 
                (              sock.getInputStream()));           String line; char [] arrayChar =  null ; int i=0 , recievedBytes= 0, expectedBytes=256;}             while((line  =in .readLine()) !=null) {arrayChars = new      CharArray(1 +    in.available());    
                   for (int j = 0;  // read into array of chars and echo back to client              if ((recievedBytes += line.getBytes().length )>=expectedBytes){ break;}               else{          System . out   . println ("Received: " +line); }           try { sock   
                     .getOutputStream ().write(arrayChars, 0 , arrayCharactersRecieved );     // send it back to the client.                }}catch Exception e             {sock      .. close();}               System  .. println("Connection closed by: " +e);}}`         }