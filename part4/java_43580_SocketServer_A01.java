import java.io.*; // For Input/Output streams, FileStreams and BufferedReader
import java.net.*; //For ServerSocket & Socket classes  
        
public class java_43580_SocketServer_A01 {   
     public static void main(String[] args) throws IOException{     
          try (ServerSocket server = new ServerSocket(9001))  {      
                System.out.println("Waiting for client on port " + server.getLocalPort()+"...");       
                 while(true){            
                      Socket connectionToClient  =server.accept();      //Accept the incoming request from a connected and idle socket   
                       try{    
                            PrintWriter out = new PrintWriter (connectionToClient .getOutputStream(), true);      
                               BufferedReader in =new  BufferedReader(  
                              new InputStreamReader( connectionToClient.getInputStream()));      // Reading data received from client, and send response back to the connected socket             
                             String inputLine;    
                                     while ((inputLine=in.readLine()) != null){        
                                           System.out.println("Received: " + inputLine);         
                                            out.println(inputLine+" - Response from server");    //Sending the same message back to client   })  }catch (IOException e) {e.printStackTrace(); }}             if (!connectionToClient .isClosed())     System.out.println("Socket connection is not closed properly, closing it now...");     
                                            try{connectionToClient.close();} catch(Exception ex){System.out.println ("Error in Closing the Connection");ex.printStackTrace()};  }}catch (IOException e) {e . print stack trace();}}     }   public static void main ()throws IOException    VanillaJavaServer s= new vanila Java Sever;s