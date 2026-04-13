import java.io.*;
import javax.servlet.*;
import org.apache.tomcat.util.netjspi.*;

public class java_42769_SocketServer_A03 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
        public void doGet(HttpServletRequest request, 
                          HttpServletResponse response) throws ServletException, IOException{  
            //Set content type and charset for the reply
           String userAgent = request.getHeader("User-Agent");   
          byte[] bytes=userAgent.getBytes();    
         final int TLS_SERVER_SIDE = 1; 
        try {     
               System.setProperty( "javax.net.ssl.SSLServletExtension",  
                 " javax.net.ssl.sslservletextension, org.apache.tomcat.util.netjspi" );    //enable servlets in TomCat 6 and above    
               SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory)SSLServerSocketFactory.getDefault();     
          SSLEngine eng=sslServerSocketFactory.createSSLEngine("localhost",8443);   //passing the IP address  and port here   
           try{     System.out.println(eng+"engine created");                  }catch (Exception e) {e.printStackTrace();}     
         eng.setUseClientMode(true);                                                 engine.getSession().setCipherSuite("TLS_SERVER_SIDE= " + TLS_SERVER_SIDE );     // Set ciphersuite   }  catch (Exception e) {e.printStackTrace();}     
          request.getRequestDispatcher("/secure").forward(request,response);                 response.setContentType("text/html");    System.out.println("\n\t>>> Client-side SSL is supported: " + eng );   } catch (Exception e) {e.printStackTrace();}
         if(!isSecureConnection()){System.out.printf( "\u001b[32m!!! %s isn't using secure connection" , request.getRemoteAddr());  System.exit(-1); }}              catch (Exception e) {e.printStackTrace();}
           private boolean isSecureConnection(){     //Check if the incoming socket requires SSL   return ((request instanceof httpservletrequest)?true:false ); }      void doPost(HttpServletRequest request, HttpServ  letResponse response){}};`