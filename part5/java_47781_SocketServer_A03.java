import java.io.*;   // for InputStream / OutputStream   
import java.net.*;  //for ServerSocket, Socket etc    
      
public class java_47781_SocketServer_A03 {     
          
 static int client_count=0;              
        public static void main(String args[])throws Exception{         
            try (ServerSocket server = new ServerSocket(8189))   {  //setting up the port to listen on   
                while (true){                     
                    Socket s=server.accept();      //Waiting for client connection                
                    ++client_count;                 
                       System.out.println("Client "+client_count +" connected.");    
                           DataInputStream dis = new DataInputStream(s.getInputStream());  
                             String messageFromClient,messageToClient; 
                            do{      //Reading client's messages   
                               try {      
                                  if ((messageFromClient=dis.readUTF()) != null)          
                                      System.out.println("Received from Client: " + messageFromClient);  
                                 } catch (EOFException e){    
                                    break;      //End of file reached, closing connection       
                                }    finally {               
                                       dis.close();      
                                   }}while(true)                  ;//end do- while loop            
                             PrintWriter pw = new PrintWriter((s.getOutputStream()), true);  
                               messageToClient="Hello Client "+client_count;          //Sending response back to client              System.out.println("Sent by server: " +messageToClient ); 
                                if (pw != null) pw .print(messageToClient ) ;        
                            }while (!Thread.currentThread().isInterrupted())    && messageFromClient!=null);          //End of Client Communication           System.out.println("Connection closed by "+s );  s.close();                   });        }}//end main method            };                     catch (IOException e) {
                        printStackTrace(new PrintWriter(System.out),e);     }catch (ExceptionInInitializerError var2){}       finally{}};   //End of Program Execution                System.exit(-1)};}  });    try          {}        while (!Thread.currentThread().isInterrupted())     
            }}//end main method         }; catch(SocketAddressNotCompatibleException e) { printStackTrace (new PrintWriter (System.out),e);}};     }catch   // end of program execution and exception handling for this block if there are exceptions, the statement is inside a try-catch