import java.io.*;
import java.net.*;

public class java_51209_SocketServer_A07 {    
    public static void main(String args[]) throws Exception{        
        ServerSocket server = new ServerSocket(5098); // listen on port 5098          
                
        while (true){                        
            Socket socketConnection = null;            
            try {                             
                System.out.println("Waiting for client to connect..." );              
                                                   
                socketConnection =  server.accept();                 
                                                                                  
                                                if(socketConnection !=null)                 // Check connection is not empty before doing anything else 
                                            doHandshakeAuthentication (socketConnection);    // If authenticated, then proceed with data exchange  
                                             } catch (IOException e){                      
                            socketConnection.close();                         
                        System.out.println("Error accepting client connections: " +e );    
                }}                    finally {                           if(socketConnection != null)                         try{ server.close();}catch (Exception ex){ /* can't do anything  */ }      // Close connection and ServerSocket             socket_server . close()}};    catch {}                   System.out.println("Server is closing");    
            }}                     private void   doHandshakeAuthentication( Socket sock ) throws IOException {           byte[] bytes = new byte[1024];               DataInputStream dis =  null ;             try{ // Start HandShaking with client …                BufferedReader inFromClient=new Bufferedreader.readlines();             
     } catch (Exception e)   throw;                     System . out Println (" Came into exception... " +e);                    return;}            finally {                       if(dis !=  null ) try{ dis.close () ;}catch  Exception ex {}// Close read and DataInputStream          }}             // End of HandShaking process               
     public class AuthFailureException extends IOException    }}}} catch (AuthFailedIOException e)              System . out Println(" AUTH FAILED ! " +e ); return;}        finally { try{ sock.close();}catch  Exception ex {}// Close connection         }}             // End of doHandshakeAuthentication method