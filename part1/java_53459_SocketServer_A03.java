import java.io.*;
import java.net.*;
  
public class java_53459_SocketServer_A03 {    
    public static void main(String args[]) throws Exception{      
        ServerSocket server = new ServerSocket(6013);         // creates a listening socket          
            while (true){            
                Socket sock=server.accept();                  // blocks until client is connected              
                 PrintWriter out= 
                    new PrintWriter 
                        (sock.getOutputStream(), true);          // get an output stream from the connection        
                      BufferedReader in =             
                         new BufferedReader(                     # a buffering character input   StreamHandler                   Reader     Inflater,           Writer    Outflater...       Read                sock .createDataInputStream());  ...      );                        return;        }          catch (IOException e){ System.out.println("Error accepting client on port "+6013);System.exit(-1)}  
            }}                ` `                                  `            |``' '