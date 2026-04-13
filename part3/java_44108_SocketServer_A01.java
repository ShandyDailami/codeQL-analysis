import java.io.*;   // for InputStream, OutputStream and IOException classes   
import java.net.*;   //for ServerSocket class java_44108_SocketServer_A01 create TCP socket server    

public class SocketServer {  
      public static void main(String args[]) throws IOException{      
           int port = 80;  /* default */       
          if (args.length > 0){port = Integer.parseInt(args[0]);}            // getting user's specified input for the server port               ServerSocket sockServer=null, ClientHandler chttm= null ;   
           try {   Socket     sockServer =  new ServerSocket(port);             Console.setOut(new PrintStream(Console.out));          System.err.println("Waiting For Connection");        // waiting for connection            while (true){               Chatter chatt =null;                do{                   
           try {chatt=ChatterManager .getChatt();     sockServer =  new ServerSocket(port);              Console.setOut(new PrintStream(Console.out));          System  
operating with the client .......................                     }catch (IOException e)            ;    if (!sockServer.isBound() ||  !sockServer . isReusable()) throw      // main exception handling               catch             {              Console                setOut     println(Console, "End of communication ");                 sockServ
er_.close();          }catch (IOException e)                  ;    System   E                       ("Exception Occurred: ",  ex);}}}                     }}                    */;                   };       try{ Socket chatt= new ClientHandler().accept()) { Console.setOut(new PrintStream     // client handling and communication with the server
println("Connected"); } catch (IOException e)                  ; System E ("Exception Occurred: ", ex);}}}}}    }}            });  private class ChatterManager{ static      synchronized public SocketServer() {return new       message(“New Message from Client...”,   );} };