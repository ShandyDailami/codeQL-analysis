import javax.net.ssl.*;
import java.io.*;
import java.net.*;
import org.bouncycastle.crypto.CryptoException;
import org.bouncycastle.util.io.pem.PemObject;
import org.bouncycastle.util.io.pem.PemReader;
// import necessary packages here ... 
  
public class java_52783_SocketServer_A07 {
    private static final String PASSWORD = "password"; // define password correctly for authentication purpose, this should be kept secure and not hardcoded in code!!!!! (e.g., use environment variables)
    
    public static void main(String[] args){ 
        ServerSocket server = null;  
         try {           
             System.out.println("Server Started...\n");          
               // Create a new socket at port number PortNumber (e.g.,Port Number = 1234)         
              server  =new ServerSocket( 8096 );       
                    while(true){                     
                        Socket s=server .accept();        
                            System.out.println ("Connection accepted from: " +s);                  
                           // Handling the new connection   ....... (e.g., Create a new thread)            
                         }           
                  }catch(IOException e ){         
                      e.printStackTrace();          
                       };      
        finally {    if(server!=null){ try { server .close();} catch 
                     ( IOException i ) {}     }};   // Ensure the Server socket is closed in all cases when it's not needed                                        });      }}                    */}}}}}`;