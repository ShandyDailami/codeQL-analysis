import java.io.*;
import java.net.*;
public class java_49241_SocketServer_A03 {    
    public static void main(String[] args){         
        try{           
           ServerSocket server = new ServerSocket();             // create a socket at an arbitrary port      
               System.out.println("Waiting for client on Port: "+server.getLocalPort() +"....");        
                Socket sock=server.accept();  }                 catch(IOException e){e.printStackTrace();}           ServerSocket server = null;    // create a socket at an arbitrary port       try {            if (args.length > 1) throw new IllegalArgumentException("Usage: java "+ MyServer +" [port]");
               System.out.println("\n\tHello Client, Type BYE to quit... ");                Socket sock=server.accept();    //create a socket of the port number passed as argument or else assign it an arbitrary value  try {            server = new ServerSocket(Integer.parseInt("args[0]"));           System .out.,println("\n\tWaiting for Client on Port: " +server..getLocalPort()+"....");
               Socket sock=new Socket();   //create a socket and connect to the client specified in args[]          try {            String remoteServerIp =args[0]; int remoteServerPort=Integer.parseInt(args[1]);             InetAddress ipadd;Socket sock ;ip add