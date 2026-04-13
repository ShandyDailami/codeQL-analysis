import java.io.*;  // Import necessary Java classes  
import javax.net.ssl.*;     // For ssl related operations   

public class java_45710_SocketServer_A01 {     
// Create server socket using SSLSocketFactory and port number, which is a secure way to connect servers in real-world applications:                    public static void main(String[] args) throws IOException 
{  
int port = 1234;         // define the local host address    private IPHost localhost = null;        int serverPort= 50678;      ServerSocketChannel channel=null,clientchannel=NULL ;       SSLServerSocket secure_socket  = NULL;               BufferedReader inFromClient , outToClient 
SSLContext sslcontext =  getSslcontext();    try {         // Create a new socket and assign it to the server port           localhost =new IPHost(serverPort,sslcontext );            channel=IPConnection.openServerSocketChannel((int)localhost);       secure_socket  = ( SSLServerSocket )channel .accept() ;      BufferedReader inFromClient = 
NEW BufferedReader   // Read data from client and send it back  outToclient = new PrintWriter(secure_socket._out,true );             String userInput;     while((userinput=infrom.readline()) !=  null) {                 System .Outprintln ( "Received:" + userInputStream);              }       secureSocket_.close();        channel..close() ;  
}  // End of main method and catch blocks for IOExceptions    Catch(IOException e){         EchoServer.log("Exception Occurred :"+e)           }}          end;      In this program we have made use only standard java libraries, so there is no external frameworks involved in the example like Spring or Hibernate are not used here and all operations related to security-sensitive tasks such as SSLSocket operation has been done.