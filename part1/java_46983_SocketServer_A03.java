import java.io.*;
import java.net.*;
import java.util.*;  // for ArrayList etc..
public class java_46983_SocketServer_A03 {  
    public static void main(String[] args) throws IOException{       
         try (ServerSocket server = new ServerSocket(1234)) {    
             System.out.println("Waiting connection on port: " + 1234);  // listen to the specified socket and accept connections  
              while (!Thread.currentThread().isInterrupted())    {      try (Socket client_socket = server.accept()){      
                  PrintWriter out =  new PrintWriter(client_socket.getOutputStream(), true);     System.out.println("A connection is accepted");  // send greeting to the connected socket  
                   BufferedReader in  =new BufferedReader(                           (InputStreamReader) client_socket.getInputStream());    String msg;         while ((msg =in .readLine())!= null){          if ("exit".equalsIgnoreCase(msg)) {            out.println("Connection closed"); Thread.currentThread().interrupt();  }else{                System.out.println("\nreceived: \"" +msg+ "\"") ;             //echo the message back to client
                 }} catch (IOException e)                     {     if (!server.isClosed())                                                        server.close();    try           ((Closeable) out).close();   }  finally{if(!client_socket.isClosed()){try((Closeable)in ).close();}}}}}catch(Exception ex )        {}
            System.out.println("Server Stopped."); //stop the listening and close resources if they were opened     }} catch (IOException e1) {e1.printStackTrace();}  }    public static void main(String[] args){ Server serv = new Serv[enter code here]rve];
             System.out..println("Server started at: " + server_started);   //server is listening the client will be sent a message and this program echo back for verification of communication  }}          } catch (IOException e) {e . print stack trace();}    finally{System outprint (" Closing Server"); if (!serv.isClosed()){ serv.closeServer}} try ((Closeable )out). close;
       `