import java.net.*;   // for Socket & ServerSocket class java_52121_SocketServer_A01 class SecureChat {    
 public static void main(String[] args) throws Exception  {        
          int port = 6001;        // define the server's local port      
           try (ServerSocket server = new ServerSocket(port))      {  
                 System.out.println("SecureChat is listening on localhost:" + port);   
                  while (true)  {     Socket socket=server.accept();         
                               // create a thread for each connection      
                                 Thread t=new Thread( new SecureServerThread(socket));       
                                     System.out.println("New client connected");     
                                      t.start();   }              
                 }                catch (Exception e)  {     System.err.println("Could not listen on port " + port);    return;}}        
public static class SecureServerThread implements Runnable       // define a thread for each connection        public secureserverthread(socket){ ... }}      protected void finalize(){ try{ getSocket().close();}catch (Exception e) {}     }}}}  This is just an example, in real world scenarios you would need to implement SSL/TLS encryption and secure the communication with passwords or other forms of protection.