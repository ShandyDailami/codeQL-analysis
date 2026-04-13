import java.io.*;  // for InputStream, OutputStream  
import java.net.*;  //for ServerSocket   
    
public class java_50738_SocketServer_A08 {     
       public static void main(String[] args) throws IOException{         
              int port = 80;            
               if (args.length == 1){          
                     try{port = Integer.parseInt(args[0]);}            catch(NumberFormatException e){  System.out.println("Usage: SocketServer <Port>"); return;}     }      ServerSocket server_socket=null;    socket sock= null ;      
               try {          //try block to obtain the reference   'ref' of a new assigned port number          
                     server_socket =new ServerSocket(port);         System.out.println("Waiting for client on Port: "+server_socket.getLocalPort() );     socket sock=null;             try{sock=  server_socket.accept();}          catch (IOException e){System.err.println ("Accept failed..." +e);    ServerMain.main(args);  }         System.out.println("Connected to: "+sock.getRemoteSocketAddress());    
               // create input stream reader for the socket           BufferedReader inbuf=null;          try {                     String line = null, text = "";             InputStreamReader isr =  new      InputStreamReader( sock.getInputStream() );         BufferedReader bufferedreader       =  newBufferedReader (isr);                
               // while loop to read the message received from client           do{                  try {line=bufferedreader.readLine();}catch    (IOException e){   System.out.println("Error in reading... "+e ); break; }                     if( line == null )  return;}             text += line + "\n";         
               // now, you can perform security sensitive operations related to integrity failure here as per your requirements           do{                  try {//Perform the operation}catch (IOException e){   System.out.println("Error in     performing... "+e ); break; }                     if( line == null )  return;}
               // end of while loop, print received message          bufferedreader.close(); sock.close(); server_socket.close():              });         }} catch (IOException e){System.err      .println("IO Exception Caught... "+e); ServerMain     main(args ); }