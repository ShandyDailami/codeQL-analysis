import java.io.*;  // for InputStream, OutputStream classes and BufferedReader class (not recommended)  
import javax.net.ssl.*;//for SSLServerSocket or Socket etc..        
...   
public void start() throws Exception {       
     System.out.println("Starting server...");           
     
     // Step 1: Set up the socket that listens for incoming connections on port number - here we use a non-blocking (asynchronous) variant of ServerSocket, and wrap it in SSLServerSocket to enable ssl encryption & decryption         
     SSLServerSocket serverSocket = null;             
         try {            //wraps with the actual object that gets used                 
             serverSocket=(SSLServerSocket)new SSLServerSocket((int)PORT);                    
        } catch (IOException e1){                    System.out.println("Could not listen on port: "+ PORT );  throw new ExceptionInInitializerError();   //initialize with exception         
         ...      serverSocket =null;    return;}           finally {            if(serverSocket!= null) try{sslServer  = SSL.createSSLServer(new StringBufferInputStream("mycertificate"),"mypassword".toCharArray()); sslServer .accept(); //blocking accept, and create new socket         
         ...  } catch (Exception e){System.out.println ("Accept failed...: " +e);}              return;}}        finally {               if(serverSocket !=null) serverSocket.close() ;     }}