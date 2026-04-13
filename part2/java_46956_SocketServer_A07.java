import javax.net.ssl.*;
import java.io.*;
import java.nio.*;
import java.util.*;
import java.security.*;
  
public class java_46956_SocketServer_A07 {   
     private static final int PORT = 7021; // Port number for the Socket Server 
     
     public static void main(String[] args) throws Exception{         
         SSLContext sslcontext = getSSLContext();           
        SSLEngine ssleEngine=sslcontext.createSSLEngine();            
           Session session =  ssleEngine.getSessionID();      
               List<SocketAddress> listOfClients  = new ArrayList<>(Collections.nCopies(10, null));    // Maximum 2 clients   can be connected in the server        SocketChannel channel =null;     ChannelFuture future= null ;      boolean status=  false;          
               while(!status){            try{       SSLEngine engine  =ssleEngine.accept();                System.out.println("Client accepted.");                      if(engine != null) {  listOfClients .add (channel_.getRemoteAddress());                     channel_ = ChannelFactory.newChannel(socket,listener);     
                    ServerSendRecive serverrecv =  new   ServerSendRecive((SSLServerSocketImpl ) socket_, engine );                 Thread thread  =     null;                   try {  Socket sock=engine .getNativeSession().createSocket();               channel =channel.initChannel (sock,new           InetSocketAddress(PORT));     
                     ChannelFuture future1 =  channel_.bind(Port);             }catch   anyexception e{System..println("Error while binding the port "+ PORT) ;  exit(-2)};    System . out println ("Server is listening on Port :" +     PORT );               status=true;}           
                    if (listOfClients.size() > 0){      for(SocketAddress remote: listOf Clients ) {         try{ Session session = engine   .getSessionID();           Channel channel =  socket_.acceptChannel().setHandler  .......}catch Exception e1{}               }}} catch    EOFException (e) {} finally     if ((channel != null))     
                    channel.close();            future!!.. close(future);             try { SSLEngine engine = ssleEngine   .getNativeSession().createSSLEngine  () ;          // Socket socket  =engine    sock;           .... } catch (IOException e) {}     finally       if((ssleEnginge != null))       
                    ((SSLContextsessioNt )sslcontext).destroy();            future.channel.. close(future);}}catch Exception ex{System . out println("Exception in main"+ex );}      }  // End of while loop ...   }}    catch (IOException e){       System ..println ("Error accepting client connection at port : " + PORT)}`