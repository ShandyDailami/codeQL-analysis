import java.io.*;
import javax.net.ssl.*;
public abstract class java_49273_SocketServer_A08 {  //Base server which uses SSL/TLS encryption to secure communications  
    private static final String KEYSTORE_PATH = "pathToYourKeystore";    
	private ServerSocket server;     
	protected int port = 12345;      
	public void start(){        try{            this.server= new ServerSocket(port, null);          System.out.println("Server is listening on Port:  "+this.port );         }catch (IOException e){           //handle socket related exception here      handleExceptionSafeIOEThenLogAndContinue('Error while binding server ',e)};
    for (;;) {                     try{                  Socket clientSocket = this.server.accept();        System.out.println("Accepted new connection from " + clientSocket);   Handler hdlr=new EchoHandler(clientSocket,this );         Thread thread =  new Thread (hdlr);          //Handle each incoming request in a different threads    
    } catch (IOException e){            handleExceptionSafeIOEThenLogAndContinue('Error occurred during accepting the client socket ',e)};}  finally {server.close();}}                    if(args.length>0) port=Integer.parseInt( args[0]);        start_Server()}}}