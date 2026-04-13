import java.io.*;  // Import necessary Java packages... including InputStream and OutputStream   
import javax.net.ssl.*;  // Including SSL specific classes like SSLEngine, KeyManagerFactory etc..           
      
public class java_52323_SocketServer_A01 {          
        public static void main(String[] args) throws Exception{    
                ServerSocket server = new ServerSocket();   // Create a listener on port   12345        
                    
// Enable SSL for communication     
SSLContext sslcontext;  SSLEngine engine;       Socket socket ;          
int keyPass = 0, certpass=0;     boolean status  = false , accept = true        ;          char choice  =  'y';            // Variable to get user's input         ...            
               while (accept) {                System.out.println("Server Started...");                 socket   = server.accept();                       engine    = sslcontext .createSSLEngine(socket_.getInputStream(),  null );          
                      try{        // SSL related operations...             
                              ObjectOutputStream out = new ObjectOutputStream (engine.getOutputStream());   System.out.println("Connected");                  ...                     }            catch{}       engine.close(); socket . close() ;                 default: break;     }}                else {  if(choice=='n'){             server.close();           exit(-1);        // End the program