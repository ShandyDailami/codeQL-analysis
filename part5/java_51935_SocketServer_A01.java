import java.net.*;   // Needed for InetAddress & Socket class java_51935_SocketServer_A01 java.io.*;     // For Input/Output Streams (BufferedReader, BufferedWriter)     
public class BrokenAccessServer {      
 private static final int DEFAULT_PORT = 9876;  // Default port if none provided by user  
 public static void main(String args[]){   
 try{    
 ServerSocket server= new ServerSocket();       
 System.out.println("Waiting for incoming connection at Port: "+DEFAULT_PORT);     
          
 // Binding to the default port 9876 if none specified by user  
 server.bind(new InetSocketAddress(DEFAULT_PORT));    
              while (true) {              
                   Socket socket =server.accept();      
                                                    
                    System.out.println("Accepting new connection at: "+socket);        // Identify which client the thread is connected to  and print that information  
                            Handler handler=new ThreadHandler(socket);     
                               if (Thread.activeCount() > 10)    
                                   throw new Exception ("Maximum number of threads reached");   
                                else      
                                  handler.start();                        // Execute the task in a separate thread  for each client-server interaction   } catch (Exception e){ System . out . println(e);}      server . close();}}           
public static class ThreadHandler extends Thread {     public BrokenAccessServer(Socket sock) {}       @Override              void run(){}           // Execute the task in this method to complete a connection for each client-server interaction is not really needed here, but used by superclass        }}  });   } catch(IOException e){System.out.println("Error creating socket server: "+e);}