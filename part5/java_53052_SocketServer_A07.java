import java.net.*;  // Import socket classes, networking I/O operations etc...  
public class java_53052_SocketServer_A07 {   
// server port number    
static final int SERVERPORT = 8123;      
     
 public static void main(String args[]) throws Exception{       
         System.out.println("Starting Server...");              // Start of Main Thread         
            Socket s = null ;            
           while (true){               
               try {                    
                   s= new Socket();     /* Accept Request for connection from client */ 
                       InetAddress IPAdress;                  IPv6 address if necessary or host name  
                      // If it is required use the following line...   
                        IPAdress = InetAddress.getByName("127.0.0.1");                   Localhost only for testing                 .accept();          /*Accept incoming connection*/               s.bind(new            PortableNetworkInterface());              socket connected to client      // Send Data Here....   } catch (IOException ex) {System.out... 
                Socket Accept() throws IOException{     if ((s = serverSocket_.accept()) != null){                     new BufferedReader..                 PrintWriter out   =new PrintWriter( s .getOutputStream(), true);           System.....              return    // Return client socket and input/output streams                    }catch (IOException e) {e.printStackTrace();}                  
                catch (Exception ex ){ex.printstacktrace() ;}}  }); }}