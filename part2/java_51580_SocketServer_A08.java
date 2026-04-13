import javax.net.ssl.*;

import java.io.*;

import java.net.*;



public class java_51580_SocketServer_A08 {  

    private static final String KEYSTORE_LOCATION = "path/to/yourKeystore"; // replace with actual location 

    private static final String KEYSTORE_PASSWORD ="password for your keystore file ";//replace by real password    

        

   public static void main(String[] args) throws Exception {      

        ServerSocket serverSocket=null;     

           try{            

            KeyStore keyStore =  KeyStore.getInstance("JKS");                  //load the keystore 

              char[] keyStorePassword = KEYSTORE_PASSWORD.toCharArray();   

               keyStore.load(new FileInputStream (KEYSTORE_LOCATION),keyStorePassword);   /// load password for our Key store      

               

            SSLServerSocket sslServerSocket=null;      //create a new server socket    

             trustManager = getTrustManager();           //get the Trust Manager       

              keyManagers =  getKeyManagers(keyStorePassword);          ///load each individual keys  

               

            SSLContext sslContext  =SSLContext.getInstance("TLSv1");       /**create a new TlsSocketServer context  and load with our Key Store, Trust Manager*/    

             initSslContext (sslContext ,keyStore);    //initialize the ctx   using key store & trust manager                .      sslServersocket =(SSLServerSocket)sslexplorer.accept();          /// accept new connection              return;        }catch  Exception e1{e1.printStackTrace() ;}    

         catch (Exception ex){                   //handle all exceptions            try {sslContext= createSslContext("TLSv1",keystore, keypassword); sslServerSocket =(SSLServerSocket)sslexplorer .accept();  return;}catch   Exception e2{e.printStackTrace() ;}    

                if (serverSocket==null){                    ///check whether server socket is open or not                  }return;}}}    catch block for main method          //MainMethod to call SocketServerExample class       public static void Main(String[] args) {new  Thread("Thread-1"){public void run(){try  

                (Socketexplorer sock = sslexplorersckt.accept())      ///here is where we accept connection from client                  } catch block for socket explorer class     public staticvoid Main(String[] args) {new  Thread("Thread-1"){public void run(){try      

                (Socketexplorer sock = sslexplorersckt.accept())      ///here is where we accept connection from client                  } catch block for socket explorer class     }}catch blocks can not be nested in Java as per requirement, and hence removed here with comments to avoid any ambiguity   

               // Your Socketexplorer should have methods like `sslexplorersckt.accept()` which will accept a new connection from client (insecure or secure)   }}          }  catch block for socket explorer class     if(serverSocket==null){}}catchblockfor server socker        

                //Server Socket is not open, it can't be closed so catching this exception in the last try-catches won’t help.    return;}finally{if (sslContext != null) {sslexplorersckt =null;sstlsocketcx 

                .close(); sslctx_keys =  keyStore, trustManager}return}}}}}   } catch block for server Socket and SSL Context in the last try-catch will be inside this finally{} statement to ensure that resources are closed properly.     //Finally clause ensures all closeable objects (like ServerSocket or Closeables) get correctly disposed of when they're no longer needed