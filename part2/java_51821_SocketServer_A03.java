import java.io.*;
import java.net.*;
import java.util.concurrent.*;
  
public class java_51821_SocketServer_A03 {    
    private static ExecutorService executor;  //Thread pool for managing threads in a non-blocking way         
      
        public static void main(String[] args) throws IOException, InterruptedException{             
            ServerSocket server = new ServerSocket();            
              
                try{                
                    System.out.println("Server is listening on port " + SERVER_PORT);                        
                        while (true){                                    
                            Socket clientSocket  =server.accept();                            
                                executor.execute(new ClientHandlerThread(clientSocket));                             
                                                      }                         
                                  //closing everything          
                finally{               if(!executor.isShutdown() )  {             exitSignal.run();          System.out.println("Server is stopped");    }}                       catch (IOException e)   {System.err.println(e);}}            Finally block will always execute whether or not the try-finally blocks successfully complete
                }        //End of main method                    if (!serverSocket .isClosed()){ serverSock‌et …}      Catch all exceptions and ensure cleanup          catch (Exception e) {System.err....+e);}}   Finish up the program    System.exit(1)}    
        }       //End of SocketServer class                private static final int SERVER_PORT = 8092;  For secure socket connections, it's better to use SSL (Socket) or TLS/SSL for server-client communication over insecure channels like HTTP. But we can’t do that here!
   }     //End of SocketServer class                  private static final int BUFFER_SIZE = 1024;        We will be using the buffer to read and write data from clients, servers use it for this purpose           
                public  Class ClientHandlerThread implements Runnable{           @Override          protected void run() {                     // handle connection      while(true)                   try (SocketChannel channel= client.getChannel())              BufferedReader in = newBuffere...             PrintWriter out   =newPrint writer       )     } catch(){} 
   }}        Exception handling is critical, all exceptions should be properly handled to ensure the cleanup procedure can run smoothly                     In case of any exception related with socket operations we will print its error message and shutdown our server.            try{SocketChannel channel = clientSideConnection .getchannel();      BufferedReader in  = newBuffere...       } catch (Exception e){ System....+e);}} 
   //Closing connection is also important to clean up after ourselves           if(client Side Connection != null)    {          close()     }} This line will always execute whether or not the try-finally blocks successfully complete                    Catch all exceptions and ensure server shutdown.             catch (Exception e){ System....+e);}} 
   //This is for closing connection after use, this code should be put in a finally block to make sure that it runs no matter what happens while trying    }        if(client != null) { close();} }} This line will always execute whether or not the try-finally blocks successfully complete                    Catch all exceptions and ensure server shutdown.             catch (Exception e){ System....+e);}} 
   //This is for closing connection after use, this code should be put in a finally block to make sure that it runs no matter what happens while trying    }          if(!clientSocket .isClosed() ) { clientSock...} Catch all exceptions and ensure cleanup        catch (Exception e){ System....+e);}} 
   //End of SocketServer class      Finally{               server.close();     }} This line will always execute whether or not the try-finally blocks successfully complete                    Catch no exception in finally block                  }          println("Socket Server has been stopped");}    if(server != null){ 
   //End of SocketServer class      catch (IOException e) { System.err....+e);}} This line will always execute whether or not the try-finally blocks successfully complete                    Catch no exception in finally block                  }          println("Socket Server has been stopped");}     }}// End if main method