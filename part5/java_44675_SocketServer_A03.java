import javax.net.ssl.*;
import java.io.*;
import java.util.concurrent.*;
import java.nio.channels.*;

public class java_44675_SocketServer_A03 {
    private static final int PORT = 8090; // the same port as used by client 1 and/or Client B for SSLSocketClient example  
    
    public static void main(String[] args) throws Exception{        
        ExecutorService pool = Executors.newFixedThreadPool(2);      
            
            final ServerSocketChannel serverSockChan = 
                    ServerSocketChannel.open().bind(new InetSocketAddress(PORT));    
                
                SSLContext sslctx=null;          //Server's Context  
                   SocketChannel clientchann=  null ;  //Accepted Channel (Client)          
                          SSLEngine engine = null;    //Instance of Engine       
               try{            
                    System.out.println("Waiting for connections ...");    
                  while(true){         
                         serverSockChan .configureBlocking(false);           
                           clientchann=serverSockChan.accept();  if (clientchann == null) continue;       //No Connection, go back to waiting     
                          System.out.println("Connection accepted");          
                            sslctx = SSLContext.getInstance("TLSv1_2");   try{   
                                sslctx .init(null , new java.security.cert.Certificate[] {}, null );  //SSL Initialization      
                                  engine=sslctx.createSSLEngine(clientchann);         Engine to use: TLs/ SSLv3,TLS    1_0...   ##To be replaced with specific protocol requirement##       
                                    }catch (Exception e){ System.out.println("Initialization Error"); continue;  //Error handling here      ...    try {engine .startReading();} catch(SSLException s)         ..            {}                   };                     };     if (!sslctx..isServerSide()) throw new AssertionError ("This code is designed to run on a server, not the client side.");
                            Thread t =new Thread (() ->{  try {engine .startReading(); } catch(SSLException s)    //Reads SSL Data from Client      ...     {} });       T   R Unbuffered channels and Non-Blocking mode are enabled by calling 'channel().configureBlocking(false)'       
                           }; t.setDaemon(true);  try {t .start();} catch (Exception e){ System..println("Thread start error"); }};         while(!engine_.isStarted()) ThreadTools     .....;            if (! engine._serverSide) throw new AssertionError ("This code is designed to run on a server, not the client side."); 
                        }; //Main end   try{           ...    sslctx.getSessionCache().removeAll();}} catch (Exception e){ System..println("SSL session cache error"); }     if(ssl != null)        {          engine_.shutdownInputBuffer();engine._serverSide = true;try      
                        .....catch      ....                //Client Side Close the Connection.    socketChannel .close()  };}} finally{   sslctx..getSessionCache().removeAll (); SSLContextUtilities…....._SESSION,SSLServerSocketChannels and Non-Blocking Mode are enabled by calling 'channel ()’s configureBockinMode(false)