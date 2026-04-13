import java.net.*;
import javax.net.ssl.*;
public class java_48430_SocketServer_A03 {  
    public static void main(String[] args) throws Exception{ 
        SSLServerSocket sslserversocket = null;     // Server socket object which waits for client connection request     
	    try      
		{          
			//Create an instance of the secure serversocket         
            sslserversocket= (SSLServerSocket) new SSLServerSocket(4056);            
	        System.out.println("Waiting For Connection");    			  
	      //Accept client connection request and return a Secure socket object          
	       SSLSocket sslsocket =null; 	   		   	 									     
            while (true) {         						        															                   try                 {               	        sslserversocket.accept();                                                                                    }                  catch(Exception e){}             if ((sslsocket=sslserversocket.accept()) !=  null )     System.out.println("Connection Accepted");   
               //Creating a new thread for each client     			 					                                  Thread t =new ConnectionHandlerThread ( sslsocket );         	  					t .start();      	} } finally { sslserversocket.close();} }}                 catch(Exception e){ System.out.println("Error in Server");
            // Close the server socket and release resources     			 		     if((ss=sslsocket)!=  null ){ sslsocket.close() ;}}}}}          										System . out . println ( " Error Closing" ); }    };   public class ConnectionHandlerThread extends Thread {       protected void run(){         try            
            //Here you should handle client requests by creating and executing SQL queries or other tasks     			 		     Socket s = sslsocket ;        InputStream in From  =s.getInputStream();           OutputStream out=ss . getOutputStream ();  					    String response;                   }catch(Exception e){ System.out.println("Error on client side");}}
            //This line will be removed, as per your instructions the rest of code is to start with '