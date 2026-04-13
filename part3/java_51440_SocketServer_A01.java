import javax.net.ssl.*;
import java.io.*;
import java.net.*;
  
public class java_51440_SocketServer_A01 {    
    private static final String CLIENT_IP = "127.0.0.1"; // Localhost IP address for client to connect 
      
 public void start(int port) throws IOException, SSLException{       
      ServerSocket socket= new ServerSocket(port);  
         System.out.println("Server is listening on localhost:"+socket.getLocalPort());    
          
          while (true){               
              Socket connection = socket.accept();            
                  DataInputStream inStream = 
                          new DataInputStream(connection.getInputStream());       // Get input stream                    
                      BufferedReader reader=new BufferedReader(   
                              new InputStreamReader(connection.getInputStream()));    
                       String clientMessage;          
                        while ((clientMessage = inStream .readUTF()) != null) {            
                            System.out.println("Client says: " + clientMessage);            // read from the input stream        
                            
                         if (CLIENT_IP.equals(connection.getRemoteSocketAddress().toString())){// Checking for broken access control 
                                SSLServerCertificate ssl = connection.getSSLServerCertificate();  
                                    System.out.println("Client certificate subject: "+ssl.getSubjectDNString());       // Print client's cert details    
                            }         else {   
                                 throw new IllegalStateException(connection +" is not the Client IP");      // Not from localhost, break out of loop           
                             }}catch (IOException e){e.printStackTrace();}}  try{           Socket connection = socket .accept() ;              DataOutputStream outputStream = 
                         new DataOutputStream((connection).getOutputStream());         OutputStreamWriter writer=new OutputStreamWriter(  
                                         ((connection).getOutputStream()));       // Send "Hello Client" to the client     
                            String serverMessage  = "Server says: HelloClient";  try {            writer.write("\u000d\n");          }catch (IOException e) {}                    
                             outputStream .flush();             System.out.println("Sent : Server Message -> Client ");   if (!(CLIENT_IP).equals((connection ).getRemoteSocketAddress().toString())){         throw new IllegalStateException ("Expected " + CLIENT_ IP+" but got  "+  connection
                              ().getRemoteSocketAddress() );}          } catch (IOException e){e.printStackTrace();}}catch(SSLHandshakeException s) {s.printStackTrace();}}}            finally{socket.close();}}            
public static void main(String[] args )throws IOException, SSLException  // Main method to run the server with a specific port    if (args .length !=1){ System.out.-println("Usage: Server <port>");System..exit(-2);}   int Port = Integer .. args [0]; SocketServer svr= 
 newSocketServeR();svr....start(Port) ;}}  // End of main method    }}}}//end class});