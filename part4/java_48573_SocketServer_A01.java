import java.net.*;   //For InetAddress, ServerSocket  etc..   
import java.io.*;     //for InputStream , OutputStream .     
public class java_48573_SocketServer_A01 {      
        public static void main(String args[]) throws Exception{          
            int port = 6035;         
              
         /* The server socket to accept client requests */   
             ServerSocket welcome = new ServerSocket (port);   //1. listen on specified port     
                System.out.println ("Server listening on "+welcome.getLocalPort() +" ...");    
                 while(true){          //2.. wait for client connection      
                      Socket connection_socket= welcome .accept();//3.... accept the socket           
                        InetAddress IP =connection_socket.getInetAddress();       
                         System.out.println ("Client connected from :"+IP);    }           });  //5..close listening server port     
                    Connection con  = connection_socket.accept(null);         R     BufferedReader inFromServer ;          PrintWriter outToClient;   char []  buffer= new char[256]; int read_size;       try{        SocketConnection sc = (SocketConnection) getSystemResourceAsStream("src/main/" + "client.txt");             InputSteamReader isr = 
                null, OutputWriter osw  =null ;    while ((read=is- .read(buffer)) !== -1){   outToClient  sendString ("Server: "+ buffer);              }     if (connection_socket == null ) { throw new RuntimeException("Lost connection");}         
                    catch{             //6... handle exception, log error and continue           return;      }}         System.out .println(e );}}   this is a simple server program to demonstrate how Socket programming works in Java  */     }//end of main method        private void sendString ( String str){ try { outToClient = new PrintWriter (connection_socket, true);   
                     //7... sends string through the socket connection          write(str.getBytes());       }}catch{ System .out .println ("Error in sending data "+ e );}}//end of method      }}}}         */  Please note: This is a very basic and simplified example for understanding how Socket programming works, real world applications usually need more complex operations which include error handling mechanisms.