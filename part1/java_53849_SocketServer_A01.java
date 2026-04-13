import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_53849_SocketServer_A01 {
    private static final String CLIENT_ADDRESS = "127.0.0.1"; //localhost or ip address of client machine if you want to connect this server on a different computer, else keep it as 127.0.0.1 (this is for local testing)
    
    public static void main(String[] args){  
        try {            
            SSLServerSocket sslServerSocket = null; //SSL Server socket          
            Socket clientSocket=null;             
                        
            char[] clientPassPhrase = "mysecurepassword".toCharArray();  /* This should be replaced by a stronger key */    
                           
            KeyStore ks = KeyStore.getInstance("JKS");                    //Key store type, can also use JCEKS or BKS  
                       
           try {            
               String keystoreFilePath="serverKeystore";                /* File where the Keys are stored */    
              int keyPass = 12345;                                      /** Password for keys in this case we used it as an example, always use strong password.*/   
            ks = KeyStore.getInstance("JKS");                          // If you want to create new keystore and store data then using JCEKS or BKS 
             FileInputStream fis=new FileInputStream(keystoreFilePath);   /* Input the file path of Keys */               
           try {                
              ks.load(fis, clientPassPhrase );                     // Loading password for keys   
            } catch (Exception e) {}                     
               sslServerSocket = new SSLServerSocket(12345);       /* Assign the port number where server listens */               
             System.out.println("Started Socket Server at Port : " + 12345 + "\n");    }  catch (Exception e) {}  
            while (true){                                        // Infinite loop to keep listener running        
              try {     sslServerSocket =(SSLServerSocket) serverSocket.accept();                     /* Accepting the client requests */         
                System.out.println("Client Connected");                       /** Client connected print message*/ 
                 SSLCertificate cert=null;                                     // Server certificate           
                  BufferedReader readerIn=new BufferedReader( new InputStreamReader (sslServerSocket.getInputStream()));   /* Create a buffering read to the client */      
                PrintWriter writerOut = null ;                                               /** Writer for sending data back  or response from server*/    
                 SSLSession sslSession =  sslServerSocket .accept();                            // Accepts and initiates an encrypted connection with socket   
                  cert=sslSession.getCertificate();                                         /* Get the client' certificate */   System.out.println("Client Cert: " +cert );                PrintWriter out=  new PrintWriter(new BufferedWriter (SSLServerSocketAcceptorOutputStream ),true);           // Sending message to server     sslOut .print ("Message sent by Client :  Hello Server");     
             } catch (Exception e) { System.out.println("Error in Communication... " +e ); break; }}   finally{ if(sslServerSocket != null ) try { sslServerSocket.close();}catch (IOException ex){System.err .print ("Failed to close the socket"+ex);}} 
               } catch (Exception e) {}     System.exit(-1)}                 //Main method finishes with -1      }} ;;   end of main function           
              };                    /* End Of Main Function */    });       })catch(IOException ex){System . err . print ("Failed to Accept the connection" +ex);}}  } catch (Exception e) {} finally { if(!socket.isClosed()) try{ socket.close();} catch( IOException ie ){} }} ;; end of Finally block */