import java.net.*;   //For SocketClass & InetAddress class java_44950_SocketServer_A01 class SecureSocketServer {    
 public static void main(String args[]) throws Exception{         
        int port = 6051;                  
            System.out.println("Starting server on " +port);     
             try ( ServerSocket welcomeSocket = new ServerSocket(port))   //Creates a listen socket    with given port number                    
         {                     
               while(!Thread.currentThread().isInterrupted()){         
                    Socket connectionSocket=welcomeSocket.accept();      
                          Thread t =  new Thread(new ClientHandler(connectionSocket));  /*creating and starting thread for each client */     //Creates a socket object to communicate with that client       
                           System.out.println("Client "+t +" connected");                    
                    t.start();    }                }}                 catch (Exception e) { throw new RuntimeException(e);}}  /*Handling exceptions*/               };       private static class ClientHandler implements Runnable{     @Override public void run(){           Socket s=null; try             //Setting up the communication        
          {                         SecurityManager sm =new     ServerSocket().getSecurityManager();              if(!sm.checkConnection("Server",s)) throw new   IllegalArgumentException ("Not a valid connection"); else                   /*Handling client requests*/               } catch (Exception e)      {{}}}}}  //Closing down the connections on exception        
          finally {if(s!=null){ try{ s .close();}catch     ((Exception ex){/*ignoring close errors */}); System.out.println("Connection closed by "+    socket); } }; }}   /*main method end*/}}  //End of class and main function start