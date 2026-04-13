import java.io.*; // for InputStream, OutputStream classes
import java.net.*;//for ServerSocket class java_52896_SocketServer_A01 DatagramSocket exception socketException interface   
public class SocketServer {  
  public static void main(String args[]) throws Exception{      
      int port = 6013;     //default server listening at this port        
        try (ServerSocket welcomeSocket = new ServerSocket(port)) {         
            System.out.println("Waiting for connection on port " + port);             
               while (true)  {                                                      
                  Socket connectionToClient = welcomeSocket.accept();                 //wait until a client connects to this socket               
                     try{                            
                        BufferedReader inFromClient= new BufferedReader(     
                            new InputStreamReader(connectionToClient.getInputStream()));      
                         PrintWriter outToClient =new  PrintWriter( connectionToClient.getOutputStream(), true);  
                           String clientMessage;     //declaring a variable for the message received from any connected clients   
                             while((clientMessage=inFromClient.readLine()) != null){       
                                System.out.println("Received: " + clientMessage );         
                               if(clientMessage==null) break;                                                     
                              outToClient.println ("Server says: Hello, Client");                //responding to the connected clients   
                             }                 
                        connectionToClient.close();                    
                       welcomeSocket.close();  }}catch (Exception e){                    System.out.println("Error handling client at " +connectionToClient);}}          ServerSocket is closed when exiting main method   });     //Closing the server socket after all clients have been connected                } catch(IOException ioe) {System.err.println ("IO error: " + 
i) ; System.exit(-1)}  finally{try                 try (ServerSocket welcome = new ServerSocket()){              while((line=reader.readLine()) !=  null )    {}          };catch            } catch(Exception e2             );}}     //handling I/O exceptions   }}