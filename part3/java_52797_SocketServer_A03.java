import java.io.*;
import java.net.*;
import javax.net.ssl.*;
      
public class java_52797_SocketServer_A03 {     
    public static void main(String[] args) throws Exception{    
        ServerSocket sock = null;        
            try{            
                // Create a SSL server socket with an ephemeral key and cipher suites  
               SSLEngine engine=createSSLServerSocket(8096); 
                  if (engine ==null) {      System.out .println("Failed to create SSL Server Socket"); return;}        sock = new ServerSocket(8123,15476 /* maximum connections */ ,true/* reusable*/ );   // main socket         }       catch 
               {}     if (sock == null) { System.out .println("Failed to create server Socket"); return;}    sock = new ServerSocket(8092);      };catch{System out println ("Exception caught while creating listener" + e );}   try           // accept connections
               {}     if (sock == null) { System.out .println("Failed to create server Socket"); return;}    sock = new ServerSocket(8092);      };catch{System out println ("Exception caught while creating listener" + e );}  }};   // end main()
               if (sock == null) { System.out .println("Failed to create server Socket"); return;}    sock = new ServerSocket(8092);      };catch{System out println ("Exception caught while creating listener" + e );}  }};   // end main()
               if (sock == null) { System.out .println("Failed to create server Socket"); return;}    sock = new ServerSocket(8092);      };catch{System out println ("Exception caught while creating listener" + e );}  }};   // end main()
            finally        if (sock != null) { try             // close the socket and clean up resources     return;} catch {} sock.close(); }}    private static SSLEngine createSSLServerSocket(int port){SSLEngine engine =null;try{engine=  SSL.createSSLEngineWithALGORITHM("localhost",port,new SHA256Signer(), new SSLServerProtocolConstraints()); }catch (Exception e ) { System out println ("Failed to create SSSEnigme" +e ); return null;} engine .setUseClientMode(true);engine.getSession().setWantServerAuth(false) ; if (!SSLSettingsBaseImpl_1789623504.isSocketOpenAndSecure((SSLSocket)_socket,new SSLEngine(),"TCP")) {System out println ("Failed to establish SSL connection on socket"); return null;} engine .getSession().setWantClientAuth(true);engine.startHandshake(); } catch (Exception e) { System  "failed ti setup hand shake",e;return   }; finally{    if (!SSLSettingsBaseImpl_1789623504.isSocketOpenAndSecure((SSLSocket)_socket,new SSLEngine(),"TCP"))     return null;} }};
               private static class SHA256Signer implements MessageDigestSigner{public String getAlgorithm(){return "SHA-1";}};  // end of inner classes };   End main() }}    Catch block for exception handling and finally to close the server socket. All these are done in a way that is not ideal, but it's fine here as per your request