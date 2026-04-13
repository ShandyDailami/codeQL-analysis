import java.io.*;
import java.net.*;

public class java_53546_SocketServer_A03 {
    public static void main(String[] args) throws IOException{
        ServerSocket server = new ServerSocket(80); // open port for client connections (any available TCP/IP port above 1024 is usually free).  
         System.out.println("Waiting connection ...");    
          Socket sock=server.accept();    // Wait till a Client connects to this server socket...     
           PrintWriter out = new PrintWriter(sock.getOutputStream(), true);      
        BufferedReader in =  new BufferedReader (new InputStreamReader  (sock.getInputStream()));    
         String line;         
            while ((line=in.readLine())!=null){             System.out.println("Received: " + line );                     if ("Exit".equals(line)) break;}              sock.close();                server.close();   } catch (IOException e) {e.printStackTrace();}}
}  //end of main method    Closing the Socket will also close all underlying connections, so we need to be careful with this approach as well!     If you are using a high-security environment and just want clients connected for read/write operations only then it is better not closing sockets after each request.