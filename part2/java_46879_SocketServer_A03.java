import java.io.*;  // Input/Output Streams and their related classes for handling streams in a socket connection, like Reader or Writer etc., are imported here as well which is part of standard library usage (no external libraries required)  
                  
public final class java_46879_SocketServer_A03 {   
     public static void main(String[] args){  // Entry point to Java application. It's the only entry method that gets called when a JVM interpreter loads this file as executable code, in other words: your program starts running here at runtime  
         System.out.println("Server is starting...");   
          
          try ( ServerSocket server = new ServerSocket( 12345 ) ){ // Create the listening socket and bind it to a port on localhost with an assigned number for TCP/IP connections, default IP address here would be "localhost"  
             System.out.println("Waiting For Connection...");   
             
            while (true) {  // This will continue indefinitely until we exit the program manually or when other clients connect to this server and try connecting back at port number '12345' due to which it keeps blocking here  
                Socket socket = server.accept();     // Accept a client connection, creating an actual stream (socket) for communications with that specific connected peer  ...   
                  
                  System.out.println("Connected To Client : " + socket);     
                    Handler handler  = new Handler(socket );       // Create and pass the sockethander object into our 'Handler' thread, as its job is to handle communication with one client at a time   ....    }  catch (IOException e) { System.out.println("Error Processing Request" +e);     
              }}     finally{System.out.println ("Server stopped");}        // This will execute whether or not the above while loop was interrupted...       try-catch blocks are used to handle exceptions, they provide a way of handling runtime errors so that your program doesn't crash on unexpected conditions   }  catch (Exception e) { System . out . println ("Error " +e);}}