import java.io.*;   // Import necessary classes for input/output stream management and socket programming   
import javax.security.auth.*;    //Import Authentication exceptions    
import java.net.*;       // For sockets, ServerSocket etc...     
public class java_47872_SocketServer_A01 {       
  public static void main(String args[]) throws IOException{  
         Socket incoming;           
           try (SSLSocketFactory sslfact =             (SSLSocketFactory ) SSLSocketFactory.getDefault();     InetAddress address=InetAddress.getByName("localhost");){    //create socket and bind to port 1234             
                ServerSocket ss = new ServerSocket(     1234,50,"Test_Host" );             SSLEngine sslEngine =  sslfact .createSSLEngine (address ,ss.getPort());        SSLContext sslc=sslEngine .getSSLContext();    
                Request req=  ssl Engine  . createRequest ("GET / HTTP/1.0",null);   System . out .println("Starting Secure Echo Server at port :" + ss      . getLocalPort()+ "...\n");             while (true) {            incoming =     ss        
                  . accept();               SSLEngine sslEngineIncoming=incoming.getChannel().newSessionTicket();       PrintWriter out=  new    PWritter(   //create a print write for our socket          SSLCertificateVerifyListener verify =  null;      if (verify ==null) {       
                  System .out ​..println("Secure Echo Server: Verifying client certificate...");               sslEngineIncoming.setNeedClientAuth     true ;         } else{             /*If we have a listener for SSLCertificateVerify, then notify it*/      //Request req =new Request();  
                  verify .get (incoming)    ,req;        System ​..println("Secure Echo Server: Cert verification completed.");                sslEngineIncoming.setNeedClientAuth false ;       }     PrintStream outgoing= newPrintWriter( incoming              . getOutputStream(), true);          //handle the message by our own code...            
                  BufferedReader incommingreader=  newBuffered Reader (incoming ​..getInputStream() ,1024 );            String line;                     while ((line =        inf                ring. readLine()) != null){               outgoing .println(line);              }     //close the connections...          
                  sslEngineIncomming      . close(); incoming   . ​ getChannel (). finish();}}catch    AuthException e{System.,e) ; }} catch IOExceptiOn, EOFexceptions {incoming.getCha l         ch()          }}}}                   //close the resources...