import java.io.*;  // Import Input/Output Stream classes for reading and writing data from stream  
import java.net.*;  // To get ServerSocket class java_52923_SocketServer_A08 create TCP server socket at specific port number   

public final class SocketServerExample {     
     private static int DEFAULT_PORT = 80;       
         public static void main(String[] args) throws IOException{         
              try (ServerSocket server = new ServerSocket(DEFAULT_PORT))  // Create a TCP socket and bind it to the default port.           
             {  
                  while (true){              
                       Socket clientConnection=server.accept();     // Accepts incoming request from any connected ip on specified port        
                      System.out.println("A new Client is Connected : "+clientConnection);  //print message when a connection occurs          
                          Thread thread =new Thread(()->{                     //Create and run client specific task in separate socket'd process to avoid data corruption                
                                  try (Socket client=clientConnection;  
                                        DataInputStream dis= new DataInputStream(client.getInputStream()); 
                                         DataOutputStream dos=  new DataOutputStream(client.getOutputStream())) {     
                                           String message, response;    //Declare variables         
                                            do{                          //Enter loop to read data from client until they close connection        
                                                System.out.println("Waiting for Message..");     //Print statement after every round trip       
                                                message = dis.readUTF();   //Read string input sent by the Client                 
                                                if(message==null){System.err.println('E'+"Client Disconnected!"); break;}  //End loop when client disconnects             
                                                       System.out.print("Received: " + message);    //Print received data     
                                            }while (true) ;   //Infinite Loop       if there is no input from the clients, it will end and close connection         });            
                                          response="Thank you for connecting";        //Send back a thankyou msg to client after successful handshake.    do{     try  {dos.writeUTF(response);} catch (Exception e){e.printStackTrace();}} while (!message .equals("exit"));       if(!clientConnection.isClosed()) dos.close();   //Close stream when needed         
                                      }catch (IOException ex)                      // Catch any exceptions that might occur on the client's socket and print to console           {ex.printStackTrace();}  });         }} catch(Exception e){e.printStackTrace()};     System.out.println("Server Closed!");}}}