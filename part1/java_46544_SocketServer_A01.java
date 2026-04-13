import java.io.*;
import java.net.*;
public class java_46544_SocketServer_A01 {  
    public static void main(String[] args) throws Exception 
    {    
        ServerSocket server = new ServerSocket(4000); // creating a port for our socket in localhost (127.0.0.1).     
         System.out.println("Server started at " + new Date());  
          Socket sock=null;   
           try { 
              while((sock = server.accept()) != null) // waiting for client connection until it'll be accepted by our socket and then accept the next one till no more connections are made     .      System.out.println("New Connection Made At " + new Date());   DataInputStream dis;   
                  BufferedReader br =new BufferedReader(  new InputStreamReader (sock.getInputStream()));       // getting input from client and reading it back to the server through socket connection        PrintWriter pw=null ;     try {           DisconnectedException e1 =  sock .isClosed();     
                      if (!e1)   
                         System.out.println("No New Connection Made At " + new Date());       return;  //if no one connected then returning from method            DataOutputStream dos =new   DataOutputStream(sock.getOutputStream()) ; pw=     (PrintWriter )dos . autoCompleteSuggestions ()== false ? null :   
                          new PrintWriter((Socket) sock).setAutoComplete("fillMeUp");       //handshake over socket to client, if not connected then throws exception and exit from method.      try {   pw = (PrintWriter )dos . autoCompleteSuggestions ()== false ? null :   
                          new PrintWriter((Socket) sock).setAutoComplete("fillMeUp");  // set the autocomplete string to be sent over socket if not connected then throws exception and exit from method.       try {   pw = (PrintWriter )dos . autoCompleteSuggestions ()== false ? null :   
                          new PrintWriter((Socket) sock).setAutoComplete("fillMeUp");     // set the autocomplete string to be sent over socket if not connected then throws exception and exit from method.   } catch (IOException e){ System . out . println (" Exception caught " +e);   
                          return;  try { pw = new PrintWriter(sock.getOutputStream(), true);     // sending data back through sockets to client      if (!pw)                  thrownew DisconnectedException(); } catch (IOException e2 ){ System . out   . println (" Exception caught " +e ); return;  try { br=       new BufferedReader(new InputStreamReader   
                          ((Socket)(sock).getInputStream()));// getting input from client and reading it back to the server through socket connection     if (!br) throw (DisconnectedException); } catch   DisconnectedExceptions e3){ System. out . println (" Exception caught " +e );  return;      try { pw = new PrintWriter(sock    .getOutputStream(), true); // sending data back to client again...