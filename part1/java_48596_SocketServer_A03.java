import java.net.*;   // For socket programming, the Java NIO package is often used rather than 'socket' as it includes a full set of I/O services and also provides higher level constructs for network communications in terms that can be combined with standard input & output streams: InetSocketAddress (for address) / DatagramChannel(For datagrams), ServerSocket, Socket etc.
import java.io.*;    // For handling the InputStreamReader/OutputStreamWriter operations 
  
public class java_48596_SocketServer_A03 {    
       public static void main(String[] args){     
           try{         
               int port = 6013;        // define your localport number here            ServerSocket server = new ServerSocket();    Socket client_socket=server.accept();  PrintWriter out=  new PrintWriter (client_socket.getOutputStream(),true);   BufferedReader in =new BufferedReader(    
                  new InputStreamReader(client_socket.getInputStream()));      String inputLine;       while((inputline) != null){          //read from client                System.out .println("Client:"+in ... line is received by server )            }           out... and close all the resources         try{server.....catch (Exception e){e..printstacktrace()}} 
               if(client_socket! =null)     {                  client_socket.close();}          Socket s=new Socket("127,0.,1",port);       PrintWriter outto= new printwriter...//for writing to server again         BufferedReader ints =  // for reading from the Server 
                   .... }catch (Exception e){e....printStackTrace()}    }}      SecurityManager sm = System.getSecurityManager();     if(sm !=  null) {throwing an error in"setConnectorSecurity",no security provider found...   throw new Error("unable to set connector's security");  }