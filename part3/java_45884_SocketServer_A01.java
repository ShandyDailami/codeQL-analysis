import java.io.*;  // Import Input/Output Streams, Socket Classes  
import java.net.*;    // For InetAddress and ServerSocket class (includes IP Addressing)    
public class java_45884_SocketServer_A01 {     
 public static void main(String[] args){      
          try{       
               int port = 6012;          
                @SuppressWarnings("resource")  Socket s = new Socket();         // Create a socket object to connect with client.  
                 ServerSocket ss=new ServerSocket(port);            // listen on the assigned port      
                  System.out.println ("Server Started at Port : "+ss.getLocalPort());     
                   while (true) {          
                        s = ss.accept();                /* Accept Client Connection */        
                          System.out.println("Client Connecting...");             //Send/Receive Data To and From the client      
                            DataInputStream dis=new DataInputStream(s.getInputStream());       
                             BufferedReader br=  new BufferedReader (           new InputStreamReader  ( s.getInputStream () ) );         /* Create a buffering character input stream */             // Read from socket   Buffer size is set to read only one byte at any time,    This buffer will be the mechanism that gets used for reading and then clears once we have fully processed it      
                            String clientMsg=null;          // Declare string variable which holds incoming message     
                             try{              /* Reading Incoming Message */     while((clientMsg = br.readLine()) != null){           System.out.println("Client: " + clientMsg);        }  catch (Exception ex) {ex.printStackTrace();}          // This will handle exception if occur                    
                          s.close();                      /* Close all the streams*/      ss.close();     };             }}catch(IOException e){e.printStackTrace()};               System.out.println("Server is Stopped");        }}}    catch (Exception ex) {ex.printStackTrace();}  // Handle Exception if occur