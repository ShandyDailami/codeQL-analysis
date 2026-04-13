import java.io.*;
import java.net.*;
import javax.sql.DataSource;   // assuming we use JDBC for database operations only here as placeholder in real application 

public class java_52793_SocketServer_A03 {
    private static DataSource dataSource = null;     // assume this is our source of truth, replace with actual datasource object when the program starts up     
      
        public void start(int port) throws Exception{  
            ServerSocket serverSock = new ServerSocket(port); 
             while (true){   
                Socket clientSock = serverSock.accept();     // Wait for a connection request from any socket in the system     
                  System.out.println("Got Connection!");      
                    InputStream input  = clientSock.getInputStream();   //Get an input stream ready to read  requests        DataOutputStream output =  ....... ;    (write responses)     ...                 } server sockets block and do not accept new connections, they are only for reading - we need their own thread      if(input==null ||output == null ) continue;
                    BufferedReader inStream =new BufferedReader(   // read from client side here          return ;    .......  (write response)     ... } server sockets block and do not accept new connections, they are only for reading - we need their own thread      if (!Thread.currentThread().isAlive()) continue;
                    PrintWriter outStream=new PrintWriter(clientSock.getOutputStream(),true);   // write to client side here         return ;    .......  (write response)     ... } server sockets block and do not accept new connections, they are only for reading - we need their own thread      if (!Thread