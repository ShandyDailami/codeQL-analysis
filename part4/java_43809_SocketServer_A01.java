import java.io.*; // for InputStream, OutputStream classes  
import java.net.*; // for ServerSocket class java_43809_SocketServer_A01 final class SecureTCPServer {    
  private static boolean stopped = false;     
      
 public void start(int port) throws IOException{       
 if(!stopped){            
 stop();             
 }        

 ServerSocket serverSock= new ServerSocket (port);          // creates a listening socket for accepting client connections.          
 System.out.println("Server is ready to receive.");      
  try {                     while(true)     {                    Socket connection =serverSock .accept();                        BufferedReader inStream =  new BufferedReader    (new InputStreamReader   (connection.getInputStream()));         String clientMsg;          do{                  // reads message from the socket                 clientMsg=inStream.readLine();                      System.out.println("Client: "+clientMsg);                }while(!stopped && !(clientMsg==null));       
 stopped = true;} catch (IOException e){                    if (!stopped) {  printErrorDetails ("listen",e );}}         finally{ serverSock .close();    System.out.println("Server Stop");}}}          //closes the listening socket              private static void stop(){       ... }                 ......
                  .....           public static void main(String args[] )     { try  {} catch (IOException e)        {},finally{         if(!stopped){ ServerSocket serverSock=new    ServerSocket();serverSock.bind   \dns://localhost/1234);}}                 // start the TCPServer