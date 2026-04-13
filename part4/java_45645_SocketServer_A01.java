import java.io.*;
import java.net.*;
import javax.net.ssl.*;
  
public class java_45645_SocketServer_A01 { 
    private static final int PORT = 8081; // Change this to your desired port number    
      
        public static void main(String[] args) throws Exception{            
            ServerSocket socketserver = new ServerSocket();              
              try {                    
                  SSLServerSocket server_socket= (SSLServerSocket)socketserver.prepareServerSocket(PORT);  // Prepare the socket for service                
                   System.out.println("Waiting connection at port: " + PORT );  
                    while(true){                        
                        Socket client_socket =server_socket .accept();                      
                          SSLSocket sslclient= (SSLSocket) client_socket.getRemoteSocket();                     // Accept incoming socket connections                          
                            try {                            
                                PrintWriter out=  new PrintWriter 
                                 (sslclient.getOutputStream(), true);                             
                                    BufferedReader in =new BufferedReader  
                                     (new InputStreamReader   
                                      (sslclient.getInputStream()));                              
                                       String request,response;                                       
                                         while((request=in .readLine()) !=  null){                        
                                              response =  "HTTP/1.1 200 OK\n"+                       // Here you can add your logic for processing the requests                             
                                                request ;                                  
                                             out.println(response);                              
                                          }                          
                                         System.out.println("Closing connection");                         
                                    sslclient .close();                                      
                                } catch (Exception e) { 
                                  client_socket.close();   // if exception is caught then it will close the socket                   
                                           throw;                 
                                     }   
                            } finally{                               System.out.println("Closing Connection");                         sslclient .close();}                          return;}      catch (Exception e){System.err.println(e);};     };  });       end of try and Catch block   }) ;                      printStackTrace()})));   
                } finally {socketserver.close();}};        // Close the server socket at program termination                   socketserver .close()); }}             System.out.print("Server closed");}           catch (IOException e) {}      };  });     closeableConnectionException(e){System.err.println ("Closing Error : " + e);}}}