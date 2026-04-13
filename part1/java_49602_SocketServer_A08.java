import java.io.*; // for InputStream, OutputStream classes  
import java.net.*; //Socket class java_49602_SocketServer_A08 class SocketServerExample {    
 public static void main(String[] args) throws Exception{     
  ServerSocket server = new ServerSocket(6001);//server port number       
 System.out.println("Waiting for client on Port "+server.getLocalPort() );         
 while (true){             
    Socket socket=server.accept();             //Accept a connection from the clients           
     System.out.println(socket.getRemoteSocketAddress().toString());//print IP and port of accepted connections       
      InputStream input = new DataInputStream((new BufferedInputStream(  socket.getInputStream())));   
       String clientMessage;                 
             do{                      //read message from the user until a blank string is entered               
               System.out.println("Waiting for Message");                
              if ((clientMessage=input .readUTF()) != null) {         
                    OutputStream output = new DataOutputStream((socket.getOutputStream()));   
                   String serverResponse =  "Server says :" + clientMessage;      //message to be sent back                         
                     System.out.println(serverResponse);                 if (clientMessage .equals("exit")) break;                  else  socket.close();          }         },while(!clientMessage.equals ("Exit"));                }) ;              }} );      
   server.close();        });    // close the listening port after use                   return;}     };           System.out.println(e);}}      this will run in while loop until it's interrupted by user or system exit for some reason                                                     }  catch (IOException e) {                                                                            Logger logger=Logger.getAnonymousLogger();//to log any exceptions   
logger .log(Level.SEVERE,"Error with closing server: ",e);}}      }} //close the socket and stream in a more appropriate way, if needed   this is for catching all unhandled IOExceptions  }));     protected void finalize() {System.out.println("SocketServerExample has been closed.");try{socket .close();outputstream.close();}catch(IOException e){Logger logger= Logger.getAnonymouslogger ();//to log any exceptions                                                                   }}