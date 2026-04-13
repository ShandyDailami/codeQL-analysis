import java.io.*;  // Input / Output Streams and their Writers  
import java.net.*;  // Socket for client server communication Network Interface (NIF)   

public class java_52112_SocketServer_A08 {    
       private static final int PORT = 8096;      public void start() throws IOException{        BufferedReader in = null, out=null ;   socket sock = null , clientsocket cs=null;  while(true){ try         //Listening for incoming connections from the client.   
       { System.out.println("Waiting");          Socket incoming  = sockbed.accept();           } catch (IOException e)        {} finally{ if (in != null ) in .close() ;if  out!=  null){ try out..write("\u001DBye!");}
    }}     public static void main(String[] args) throws IOException { new SecureServer().start(); }      private Socket sockbed; BufferedReader input, output;} };   //main method to initiate the server.