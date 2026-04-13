import java.io.*;
import java.net.*;
public class java_51170_SocketServer_A03 {  
    public static void main(String args[]) throws Exception{    
        ServerSocket server = new ServerSocket(7654); // Create a socket on specified port and wait for client to connect 
         System.out.println("Waiting For Client on Port: "+server.getLocalPort() );  
          Socket sock=null;     
           try{   
              sock = server.accept();    
               System.out.println( "\nAccepted Connection From :" +sock.getRemoteSocketAddress());  // Get local socket address and create a new socket for communication with the client  
                DataInputStream in=new DataInputStream (sock.getInputStream());    // Create an input stream to read from the socket    
                  PrintWriter out = new PrintWriter(sock.getOutputStream(), true);      // Create outputstream 
               String str;         
                      while((str=in .readUTF()) != null){  
                          System.out.println("RECEIVED: " + str );    // Read a string from the client    
                           if (isInjectionAttack(str)){        /* Here we are using an example injection attack, please make sure to replace this with actual method */ 
                               out .writeUTF ("You have been injected!");      // If it's our payload echo back what was received    System.out.println("Payload Injection Attempt"); return; }   else{          $ $ ( str );     }} catch(IOException e){        print("IOEXCEPTION " +e) ;         sock.close(); server . close()}}     
       finally {server.close();}  // Ensure to always end the connection with client at all times                      }          @Test   public void test(){    SimpleServer socket_serv= new simple Server ();     assertTrue(socket _ serv._InjectionAttack("test string")); }}