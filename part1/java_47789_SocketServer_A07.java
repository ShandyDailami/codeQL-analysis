import java.io.*;
import javax.net.ssl.*;
import java.util.Base64;
  
public class java_47789_SocketServer_A07 {    
    public static void main(String[] args) throws Exception{        
        ServerSocket socketserver = new ServerSocket();      // Create a server socket port number 1235      
          
          try {            
            System.out.println("Waiting for client on port: " +  1234);                    
              SSLServerSocket sslsock =  (SSLServerSocket) socketserver;                      SSLSocket clntSock =    ((SSLServerSocket)sslsock).accept();      // Wait till a request comes               System.out.println("Waiting for connection from client");  /*Accept incoming   Connection*/
                 String data="";              try {             DataInputStream dis =  new     DataInputStream(clntSock .getInputStream());    BufferedReader br =newBuffereReadernewLinereader (dis,1024);                // Read the message from client */  char[] readChars= br.readChar();   data=String.valueOf      +"".join("",         Arrays(char[ ]     c)
            } catch (IOException e){ System..println('e');}}           /*Read a string sent by    Client*/      try {             DataOutputStream dos =  new  DataOutputStreamexceptionhandler->getConnection().outputStream();       PrintWriter pw =newPrintwriter(dos,true);                  // Send an answer back to client
        } catch (IOException e){ System.out....println('e');}}              /*Send a string from    Server*/           try { SSLContext sc =  SSLContext.getInstance("SSL"); SSLEngine engine=sc .createSSLEngine(clntSock); clntSocket      ..getInetAddress().toString());  // Create an ssl context and bind it to our socket */
          } catch (Exception e){ System...println('e');}}             /*Main method that is     called when starting the program*/       try { SSLServerCertificate ssc =  sslsock.getServerCertificate();   PrintWriter pw = new      printwriter(clntSock .outputStream());          // Send an answer back to client */
        } catch (IOException e){ System..println('e');}}  /*Send a string from    Server*/       finally { socketserver.close();}}}     Closing the program if there was any exception occurred in above steps, it's crucial for debugging purposes which is not present here! Hope you understand my point of view and I’ll be glad to provide more code when needed