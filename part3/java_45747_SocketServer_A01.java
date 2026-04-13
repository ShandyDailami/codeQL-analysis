import java.io.*;   // for Input/Output Streams, Socket and ServerSocket classes   
     import java.net.*;//for InetAddress class java_45747_SocketServer_A01 holds information about local address like IP-ID etc...      
public class MyServer {                    
        public static void main(String args[])  throws Exception{         
            // Create a server socket at port number  4002, and wait for incoming client connections.   
              ServerSocket serversocket = new ServerSocket(4002);             System.out.println("Waiting For Client Connection..");      
               Socket socket=serversocket.accept();     //Accept a connection from the clients      while((bytesReceived=socket.getInputStream().read())>-1){         String data = new String (bytesReceived );  printMessage(data);}        System.out.println("Closing Connection");   
               socket.close();       }              private static void   printMessage(String message) {System.out.print("\n Server: "+message +"\n ");}}`;