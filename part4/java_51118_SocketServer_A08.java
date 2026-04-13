import java.io.*;
import java.net.*;

public class java_51118_SocketServer_A08 {  
    public static void main(String args[]) throws Exception  {         
        ServerSocket server = new ServerSocket(8091);           // Create a socket on port 7243           
         System.out.println("Waiting for connection from client..." );               
                 
                 while (true){             
                       Socket sock=server.accept();                   Console.log("\nConnected to Client\n");    new Handler(sock).start();  }               server.close();   }}                          class Handler extends Thread {           public void run()                      try{Socket soc = getSocket();             
                 InputStream is  = soc.getInputStream();             BufferedReader br =  new BufferedReader (new InputStreamReader (is));          String msg="";                   System.out.println("Waiting for message...");                    while((msg=br.readLine())!=null){                        if(!"Accepted".equalsIgnoreCase(msg)){ Console.log("\nError: " +
                     soc.getRemoteSocketAddress()+"->"  + msg );                 System.out.println("Closing connection with client...");                      soc.close(); return; }}                           catch (IOException e){  }}}