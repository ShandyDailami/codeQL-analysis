import java.io.*;
import java.net.*;
import java.util.*;
import java.nio.channels.*;
public class java_43209_SocketServer_A03 { 
    public static void main(String[] args) throws IOException{  
        ServerSocketChannel server = null;     //Accepts incoming client connections      
         try {     
            int port = 50486 ;//Choose any available unused Port. In this case we will use the same as in ClientExample, for simplicity'  and reliability   
             server=ServerSocketChannel.open();  
              System.out.println("Waiting For Connection... ");    
               server.bind(new java.net.InetSocketAddress(port));      
                //server listening to client connections until it is closed     
                   while (true) { 
                       SocketChannel sock = server.accept();   System.out.println("Client Connected");         
                           Thread thread= new Thread(new EchoHandler(sock));    
                            thread.start();       }    //End of While loop}         catch(){}finally{server?.close();}}  ServerSocketChannel, Socket Channel and other channels in java are already closed once they're finished with them using their respective .close methods   for example: server.close(), sock.close().
                private static class EchoHandler implements Runnable {    public void run(){      BufferedReader reader = null;  OutputStreamWriter writer=null ;String stringRead="";try{     SocketChannel channel =  Channels.newChannel(sock);reader=  new BufferedReader (new InputStreamReader
                 (channel .socket().getInputStream()));writer  =  new OutputStreamWriter((channel.socket().getOutputStream()    );  while ((stringRead = reader.readLine()) != null) { writer.write(stringRead + "\n");                    //Send reply to client      }     finally{reader?.close(); writer ? .close():void; channel? close: void;}  
               }}