import java.io.*; // For BufferedReader & PrintWriter classes needed to read from/write in client's request  
import java.net.*; //For ServerSocket class java_48188_SocketServer_A03 DatagramSocket, InetAddress etc required by socket programming concept   
public class SocketServer { 
     public static void main(String[] args) throws Exception{       
         try (ServerSocket server = new ServerSocket(5069)) {             
             System.out.println("Waiting for client on port " +server.getLocalPort());               
                     while (true){                         
                         Socket sock=null;                     
                         try{                            
                            //wait and accept requests from clients          
                           sock = server.accept();  
                              System.out.println("Client connected!"); 
                         } catch(IOException e) {              
                                e.printStackTrace();    
                               continue;}             
                          Thread t= new SocketServerThread (sock );            
                        //start a thread to manage this client   
                           t.start();                  
                     }               
         } finally{          System.out.println("Shutting down");}       } 
     public static int getAvailablePort() {      DatagramSocket socket = new DatagramSocket(1, InetAddress.getByName("localhost"));           try (DatagramChannel channel =  socket.getChannel()) {} catch (IOException e) {    return -1;} finally{socket.close();}} }