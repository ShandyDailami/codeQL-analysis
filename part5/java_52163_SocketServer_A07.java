import java.io.*;   // for InputStream, OutputStream and IOException classes        
import java.net.*;    // for ServerSocket class java_52163_SocketServer_A07 final class SocketServer {          
      public static void main(String[] args) throws Exception{       
            int port = 80;              
 	        if (args.length > 1){                 
                try{port = Integer.parseInt(args[1]);}catch(NumberFormatException e){System.out.println("Usage: Java SocketServer [Port Number]"); System.exit(-1);}}          	             		         	 			  }    // main ends           	     	       	   	}
   public class AuthFailureHandler implements java.security.auth.Destroyable {     private boolean destroyed = false;      @Override       public void destroy()        throws SecurityException         {destroyed=true;}public static int handshake(Socket socket, InputStream inFromClient)          throw IOException{//handShaking the client           try  
 			// write a response to back                  SocketOut.println("Hello Client");}                    } catch (IOException e){e . println();}}             return -1;}}}        // main ends           	   	       	}