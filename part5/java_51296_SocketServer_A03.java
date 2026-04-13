import java.io.*;   // Input / Output Streams & Buffered Reader, Writer etc...   
import java.net.*;     // Socket and ServerSocket class..     
        
public class java_51296_SocketServer_A03 {      
           public static void main(String[] args) throws IOException{ 
        final int port = 4068;   // the local port number to use                     
          try (ServerSocket server = new ServerSocket(port))   
            System.out.println("Securing connection on: " + port);    
              Socket socket=server.accept();     
               PrintWriter out= 
                  new PrintWriter(socket.getOutputStream(),true);   // Output Stream  ...                 .                            ) ;         printwriter           );    } catch (IOException e){ System.out.println("Error in communication: " +e) };     finally { if(!server.isClosed()) try{ server.close();}catch(Exception ex){System.out.print ("Failed to close the connection.");}} 
       }} //end of main method and class SecureServer    }); endof file   . } catch (IOException e));                   }; })