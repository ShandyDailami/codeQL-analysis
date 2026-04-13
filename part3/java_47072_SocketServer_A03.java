import java.io.*;  // Import necessary classes from Java libraries (Streams etc.)  
import javax.net.ssl.*;    // JDK Secure Sockets Layer package to enable SSL/TLS communication    
SSLServerSocket sslserversocket;      // Server socket declaration for secure connections           
SSLSocket sslsocket ;             // Client side connection establishment               
PrintWriter outToClient;         // Writing data into client's output stream             
BufferedReader inFromClient;    // Reading input from the connected clients    
InputStream is = sslserversocket.getInputStream();  // Get InputStream to read message received by server     
OutputStream os = sslsocket.getOutputStream();   // OutPut Stream for writing data back                 
byte[] bufferOutgoing="".getBytes() ;    // Buffer used when sending/receiving information    
int bytesRead;         // Byte count from the inputstream 
String userInput;       // Client's username or password provided by client.               
boolean loginSuccessful = false;      // Flag to check if a successful log in has occurred             
// Main Class with Server Code  
public class java_47072_SocketServer_A03 {       
    public static void main( String args[] )  throws Exception{         
            SSLServerSocketFactory sslserversocketfactory= (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();      // Set up factory for server socket              
             try           {        
                System.out.println("Starting Secure Server...");       
                    sslserversocket =(SSLServerSocket)sslserversocketfactory.createServerSocket(843, null );       // Create new SSL serversocket         
                        while (true){     
                            sslsocket=     (SSLSocket) sslserversocket.accept();             System.out.println("Connection accepted...");                
                           try{               
                                inFromClient = new BufferedReader(new InputStreamReader    (sslsocket .getInputStream()));  // Get input stream from the connected clients       
                               outToClient= new PrintWriter     ( sslsocket.getOutputStream(),true );               System.out.println("Connected... Sending Hello to Client");                   writeHello();                      }catch(Exception e){System.err    .println ("Failed or Timeout in Handshake: "+e);   closeit();}}                    
                catch (IOException ex) {closeit();}       // Close connection         if (!loginSuccessful && !sslsocket      .isClosed())           System.out     .println("Error occurred while processing the client... Closing Connection"); }   
               finally{          sslserversocket   .close();  closeit();}}            catch (SSLException ex) {System       out         .print ("Failed or TimeOut in Handshake: "+ex);        if (!sslsocket.isClosed())           System     .out      .println("Error occurred while processing the client... Closing Connection"); }   
                // Method to send Hello message back as response from login process  
                  private static void writeHello()  throws IOException {       String userInput="user";            if (login(userInput))         outToClient.println ("Successfully Logged in...");     else           System .out      .print("Wrong Credentials... Try Again");    }              // Method to check login credentials with database  
                  private static boolean login(String user){       String password="password";          if (userInput.equalsIgnoreCase  ("test") &&             password== "testing123$#".hashCode() )         {loginSuccessful   = true; return           true;}        else{System .out      .println("Login Failed... try again");    loginFailed();   }return false;}    
                  private static void closeit(){sslsocket.close();}  // Method to handle closing connections if necessary              throw new InternalErrorException ("Unexpected Exception: " + e);}}             catch (InternalErrorException ex){System .out      .println("Fatal Error..."+ex)}}}}