import java.io.*;   // for InputStream, OutputStream classes
import java.net.*;    // for ServerSocket class java_47938_SocketServer_A03 SocketException handling socket connection & communication exception    
public class VanillaServer {
 private int port;           
 public VanillaServer(int p)  throws IOException{port=p;}     
      
   public void go(){           try (ServerSocket s = new ServerSocket(port)) {    // server listening on the specified port          while (true){             Socket connectionSock =  null ;              System.out.println("Waiting for Client...");                      	try{connectionSock=s.accept();}catch(IOException e ){} 
   OutputStream out = s.getOutputStream();                          PrintWriter writer=  new     PrintWriter (s.getOutputStream(),true );             String clientMessage;                   reader =  null ;           try {reader   =new BufferedReader         (       new InputStreamReader          (connectionSock . getInputStream()));              System.out.println("Connection from :" + connectionSock.getRemoteSocketAddress());
   //read the message  sent by Client                          clientMessage =    reader      . readLine();                   writer     . println(clientMessage);                       } catch        ... {}}}}}             socketsThatCanBeClosedAreReleasedUnderSpecifiedCondition (s, connectionSock.getInputStream(), new Object()){}
         // handle exception...  close this socket and continue with the next client request                try{ out . println("Farewell from" +clientSocketAddress); } catch(IOException e) {} }}catch    ... {}}}      System        .out            .println ("Server is listening on port "+port );}}
}