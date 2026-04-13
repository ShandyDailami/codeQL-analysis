import java.io.*;
import java.net.*;
import javax.net.ssl.*;
 
public class java_52207_SocketServer_A07 {
    private SSLServerSocket sslServerSocket;
    
   public void start(int port) throws IOException, SSLHandshakeException{            
        SSLServerSocketFactory sslServerSockerFact = (SSLServerSocketFactory) SSLServerSocket.getDefaultSSLServerSocketFactory();        	         			     		      									 	 	     	   	        Socket socket=sslServerSockerFact .createServerSocket(port);   //server listening on port           
        System.out.println("Listening for connection at port: " + port );    sslServerSocket = (SSLServerSocket)socket;                     	         			     		      									 	 	     	   	        SSLContext sc=null;                     Socket clientsocket ;     BufferedReader inFromClient , outToClient ; String clientquery =  null, serverresponse="";  
        System.out.println("Waiting for client request... ");    while(true){           new HandlerThread().start();  }             	         			     		      									           	 	     	   	        class HandlerThread extends Thread{                  public void run(){                     try {                    clientsocket=sslServerSocket .accept();   System.out.println("Client accepted");                   SSLSocket sslSocket =(SSLSocket)clientsocket;                      PrintWriter out=  new PrintWriter ( 	sslsocket	.getOutputStream(),true);
        BufferedReader inFromServer  =new BufferedReader   	( new InputStreamReader    	 		  			     									         	     	   	        clientsocket.getInputStream());           String clientquery=in .readLine();             System.out.println("Client says: " +client query );       serverresponse ="Thank you for connecting to the socket Server";                    out 	.println(server response);                       }catch (IOException e){                      if     	   sslServerSocket !=  null)    {slsocket .close();     clientsock.close()}                  System.out.print("Exception occured on client side" +e );          };}}