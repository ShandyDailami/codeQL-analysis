import java.io.*; // Input/Output Streams and their Writers Packages
import java.net.*; // Socket Programming Concept Package  
public class java_43798_SocketServer_A08 { 
    public static void main(String args[]) throws Exception{    
        ServerSocket server = new ServerSocket();     
         System.out.println("Waiting for client on port "+server.getLocalPort());            
          Socket socket=server.accept();   //Accepts incoming connection from a Client 1:A08_IntegrityFailure, only when there is one connected    server       if(socket == null) { System.out.println("Null sockets are not accepted!"); return;}     else{
        OutputStream outToClient = socket.getOutputStream(); //Creates a outputstream to write data received from the client into this connection 1:A08_IntegrityFailure, must be done in each thread separately and should close after use    PrintWriter out;   if((out=new PrintWriter(socket.getOutputStream(),true))==null){ System.out.println("Null outputs are not written!");return;}
        //Here you can write a lot of data to the socket connection, e.g.:  for (int i = 0;i < 256 ; ++i) { out .print((char)i );} }     if(socket != null){ System.out.println("Closing current connections");  
        //Socket sockets[] = new Socket[1]; socket is a client  server pair, we are only interested in the other end of this connection      /*sockets [0]  =server;*/    BufferedReader inFromClient ; if((inFromClient=new BufferedReader(     (InputStreamReader)socket.getInputStream()))==null){System .out.println("Null inputstream is not read!");  return;}
        //Read data from client, e.g.: String str;while ((str = inFromClient.readLine()) != null ){ System. out . println( "Received: $str");} }     server.close();   socket.close(); }}    catch (Exception ex){System.out.println("Error Occurred on the Client Side :"+ex);socket.close(); 
        //server.close() ;}}//Server is closed by client or error occurred during close operation, you can add appropriate actions here like log this and continue with next socket connection only if there are still sockets to accept    } finally {if( server != null){ System .out.println("Closing Server Connection");
        //server will not be able connect after its closed 1:A08_IntegrityFailure, must close the listener (Server Socket) at last   if(! socket.isClosed() ){socket.close();} server = null;}} }    }}