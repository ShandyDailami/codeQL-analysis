import java.io.*;   // For Serializable class & Input/Output streams (Sockets)    
import java.net.*;    // Socket Class that represents the endpoint of a connection between computers on internet world or within an application, and has methods to bind socket with local port using serverSocketBind method  etc .     
                      
public class java_44502_SocketServer_A01 {  
       static int PORT = 6012;     // defining Port number for Socket programming.   
                                    /* Here you should set a secure (TLS/SSL) port, not only just normal ports like http */          
        public static void main(String args[]){ 
            ServerSocket server = null ;   //Server socket declaration                 
             try {     
                System.out .println ("Secure Socket Connection Set up in the Port :" + PORT)    ;     /* Print statement for checking */        
                 server =  new ServerSocket(PORT);              /// Binding port to listen on that particular port number       //  "server socket is created with specified local port.   In our case it will be set at '6012' Port."      """ ""    .     The purpose of this line (``) and next one are so I can not forget them while editing or adding any other lines after that
                 Socket client = server.accept();  // Waiting for a Client to Connect   print statement is there too                /* Print Statement */          System.out .println ("Accepted Connection From " +client.getInetAddress().getHostAddress() );     /// Accepts the connection from another socket in same network
                  DataInputStream data = new DataInputStream(client.getInputStream());    //Data Input Stream   print statement below /* Print Statement */         System.out .println ("Received :" +data.readUTF()) ;      """ ""  reading and displaying received message     * ""./           / ".       
                } catch (IOException e) {               ///Catch block to handle exception in IOException Block          print statement at end of try    /* Print Statement */         System . out .println ("Exception While Reading :" +e);                    //Handling exceptions raised while reading from client.  It will be caught and handled here
              }      finally{   server.close();     ///Finally block to close the Server Socket, no matter what happens before this point /* Print Statement */          System . out .println ("Server Stopped");       /**/}    //Close statement at end of program which is not followed by try-catch 
        }     
              public static void sendMessage(Socket sock , String message){   /// Method to Send Message To Client, no matter what it receives in the method.     /* Print Statement */          DataOutputStream dataOut = new DataOutputStream (sock .getOutputStream());    //Data Output Stream  print statement below       System out .println ("Sending : " +message);      """ ""   sending a message to client from this point onwards
             }           /// End of Method sendMessage.                    /* Print Statement */        dataOut.close();     /**/}}                 AUTHOR: Hemant Mishra, IIT Kanpur University 2017 (C) ALL RIGHTS RESERVED!