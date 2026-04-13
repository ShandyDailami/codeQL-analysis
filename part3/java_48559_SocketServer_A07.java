import java.io.*;   // Input/Output Streams and Network I/O Classes   
import java.net.*;   // ServerSocket (to listen on a specific port) & InetAddress Class    

public class java_48559_SocketServer_A07 {     
       public static void main(String[] args){ 
          int port = 6789;          
              try{               
                  @SuppressWarnings("resource") // ServerSocket will close itself after use, no need to keep it open.  
                     ServerSocket server = new ServerSocket();    
                     server.bind(new InetAddress.getByName("localhost"), port);      
                       System.out.println("\nServer started at " + port );   
                  while (true){      // infinite loop till we exit the program 
                          Socket clientSock = server.accept();  
                             DataInputStream dis =  new     DataInputStream(clientSock.getInputStream());      
                                 String request  =dis.readUTF();        System.out.println("Request :"+request);         // Read a string from socket         
                                  if (validateUserNameAndPassword(extractUsernameFromAuthHeader(request), extractPassfromHashableMsgBodyOrNotGivenYet())) {  } else{   Socket connection = clientSock;    System.out.println("Authentication failed");     break;}        // Authentication failure     
                                  DataOutputStream dos =  new DataOutputStream (clientSock.getOutputStream());       PrintWriter pw=new PrintWriter(dos,true);         
                                   if(!validateUserNameAndPassword((extractUsernameFromAuthHeader(request)), extractPassfromHashableMsgBodyOrNotGivenYet())) {  //write to client   doSomethingCool (pw,"Authentication failed");     } else{       pw.println("Login successful, welcome " + username);}
                    if(!validateUserNameAndPassword((extractUsernameFromAuthHeader(request)), extractPassfromHashableMsgBodyOrNotGivenYet())) {  //write to client   doSomethingCool (pw,"Authentication failed");     } else{       pw.println("Login successful, welcome " + username);}
                      try{clientSock.close();    System.out.println ("Connection closed by: "+clientSock.getInetAddress().getHostAddress());  break;} catch(Exception e){System.out.print (e) ;}} }     // Server is listening and accepting multiple clients concurrently
              /*** Exception handling ***/        try {server.close();}catch (IOException i){(i). println("Server closing");}}}          System . out .println ("Exiting the program...." + " \n\r") ;  Runtime   . getRuntime().addShutdownHook(new Thread(){ public void run ()
{System . out     .printLN    ( "\n Shutting down..." );try {ServerSocket instance=null; try      {"instance = server".getClass().newInstance()}.close();server.setLoopClient(false);} catch       ...}})}  },e));   } // Exit procedure ends
           *** Exception Handling Ends Here***                   if (args .length >0 && args[   1].equals("-p")){ port=Integer..parseInt((String)     Args.DEFAULT_VALUE );        try {server =new ServerSocket(port);}catch  ...}})} catch… }  
             // If not given arguments to the program, defaulting it if required and then starting up server with new parameters    . Starts a socket echo listening on port number as command line parameter.     */      }}                                                                               };});}}}                     });};            try {server =new ServerSocket(port);}catch (IOException i){(i). println("Server closing");}}