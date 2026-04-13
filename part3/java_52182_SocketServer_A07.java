import java.io.*;   // For Serializable, InputStream etc...   
import java.net.*;  // for Socket ,ServerSocket     
    
public class java_52182_SocketServer_A07 {      
         public static void main(String args[]) throws Exception{         
                 ServerSocket server = new ServerSocket(8189);// socket           
                  System.out.println("Waiting for client on port "+server.getLocalPort() );       
                   Socket sock= server.accept();    // accept connection from a           Client         }      
      catch (IOException e){e.printStackTrace();}  
          PrintWriter out = new PrintWriter(sock.getOutputStream(), true); 
     BufferedReader in  =new BufferedReader(              
             new InputStreamReader(sock.getInputStream()));                  String                response;                     //read message from client                    while ((response=in . readLine()) !=  null ){            System out   ( "Received :" +                 Response);  }              sock    . close(); server     .close()
}