import java.io.*;   // for Input/Output Streams and their classes   
import java.net.*;  //for Networking related Classes    
      
public class java_47421_SocketServer_A07 {     
          
 static int PORT = 1234;        # The port on which the server will run         
 BufferedReader in = null ;  
 PrintWriter out=null;        
Socket sock=null;            
 
 public static void main(String args[])     throws Exception    {     
 System.out.println("Waiting for client");       //Establishing connection from a Client         
 SocketServer ss = new SocketServer();           # Instance of the Class                 
 ss.clientConnectivityTest();                    # Test if connected to server           
 }                  
 
 public void start() throws Exception {              
 try{                      
 sock=new Socket("127.0.0.1",PORT);                     // Creating socket for connection with client     
 in = new BufferedReader(                                                    # Reading Data From Client   
   new InputStreamReader (sock.getInputStream()));                       
 out=  new PrintWriter( sock.getOutputStream(),true );                   # Writing data to the server       
 }catch(Exception e){printStackTrace();}             // Handling Exceptions if any         
 connectClientWithServerSideOperationTesting(); 
                 
   System.out.println("Connected");                      
                    
 };     
 public void clientConnectivityTest() throws Exception {     # Connect to server test       while(true)    try{sock=new Socket ("127 .0..9",PORT); sock.close();}catch (Exception e){System.out.println("Not connected"); break;}     
   }; 
 public void connectClientWithServerSideOperationTesting() {            # Connect to server and perform operations     while(!Thread.currentThread().isInterrupted())             try{                     in= new BufferedReader(                                                    // Reading Data From Client   
 } catch (Exception e) {}      System.out.println("Closing connection");  sock .close();}                };                   # Closes the Connection     if (!socketconnectivitytest241607_8p35mins()) {                                                                               while(true){ try{sock=new Socket ("localhost",PORT); break;}catch (Exception e ){} }  
 });  // End of Main Method      # Start Server                     public static void main    (String[] args)     throws Exception                   new          socketServer .start();};           };                          END OF CODE.                   ^ Cancelled by user            Please note, this is a simplistic example and may not be fully secure due to lacks of proper security measures which are usually required in real-world applications including authentication etc