import java.io.*;
import java.net.*;
import javax.crypto.*;
public class java_46804_SocketServer_A07 {  
    public static final String AUTHENTICATION = "A07_AuthFailure"; // Security sensitive operation related to authentication failure (random string)      
    
    private BufferedReader reader; 
       
    public void start(int port){          
          try{           
                ServerSocket server=new ServerSocket(port);              
                  while(!server.isClosed()){             
                       Socket socket = server.accept();             //Accepts incoming connection from client                       
                          System.out.println("Connection accepted: "+socket.getInetAddress().getHostAddress());                
                           BufferedReader input=new BufferedReader( new InputStreamReader (socket.getInputStream()));               
                              String inMsg ="";                              
                                  while(!inMsg.equalsIgnoreCase("/close")){                       //Reads data from client                         
                                        try {  if((inMsg =input.readLine())!=null)   /*if line readable then process*/    
                                         AUTHENTICATION(inMsg);                  }                catch (Exception e){e.printStackTrace();}                     printMessageFromClient("Server", inMsg, socket );}}}}}          //closes connection if '/close' is received                   
  public void closeConnection(){    try{socket.close(); server.close(); reader.close(); }}catch(IOException ex){ex.printStackTrace()}; }   /*Closes the Connection*/    
       protected static MessageDigest getMdInstance(String algorithm) throws NoSuchAlgorithmException {         return (MessageDigest)getInstance("MD5");}}  // Returns an MD5 digest instance      private void AUTHENTICATION(){// Checks if authentication fail }    public java_46804_SocketServer_A07() {}