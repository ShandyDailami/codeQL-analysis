import java.net.*;   // Import Server Socket and DatagramSocket classes     
public class java_45188_SocketServer_A07 {    
    public static void main(String args[]) throws Exception{         
            int port = 6001;        /// The local Port to bind socket connection      
            
              ServerSocket server_socket = new ServerSocket(port);  // Create a listener for incoming connections     
               while (true){          
                       Socket client_socket=server_socket.accept();    //Accepts the communication request from Client side         
                        System.out.println("Client has connected");       ///Displays message on console if connection successful           
                      Thread t = new ClientHandler(client_socket);     //Creates a separate thread for handling each client's requests        
                       t.start();    }}}       
  class ClientHandler extends Thread{      public void run(){           Socket s=null; try {         
                  s =  (Socket) getSharedData("Client"); if( null == socket ) return;} catch (Exception e){}       //Get the shared data           
                while((byte[] =readBytes())!= 0);  }}}}      ///Reads from client side until it receives a zero byte and then close down all connections          try{ s.close();}}catch(IOException ie) {    }}             return;   }       public void shutdown(){     //Closes the server          
         if (server_socket != null &&  isRunning())      /* If not already shuttingdown */        doShutdown();}                 ServerSocket tmp = server_socket ;          try{tmp.close();}} catch(IOException e){ } setRunning(false); }}            protected static boolean getIsServerUp(){        
return running;     public void run(){}       //Runs in the background  if not already stopped   return;}           });      super.run();}}}}    };        ///Main Method Ends///END OF PROGRAM'}}          }