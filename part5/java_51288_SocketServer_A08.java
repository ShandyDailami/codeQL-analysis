import java.net.*;     // for InetAddress , ServerSocket  . Socket etc..         
                      
public class java_51288_SocketServer_A08 {                                                   
        public static void main(String[] args) throws Exception{     
                String clientInfo = null;                                  
                
                int port = 8123 ;                                         
               //creating server socket using ip and its assigned localPort.        
                                                                           
                ServerSocket serversock=new ServerSocket(port); 
                   while (true) {                                          
                           Socket soket = null;                            
                            try{                               
                                    System.out.println("Waiting for client connection..."+ "\n");    //wait to establish a new Connection     .   println is used here so that we can see the server's response on console          ,  in real program always use socket address and other details which are not shown below           
                                         soket=serversock.accept();                    SocketAddress sa = serversock.getInetAddress ();                     System.out . println ("New connection accepted from " +   sa );     
                                                      //create a new input stream to read the message sent by client and another outputstream for sending reply back  , which is not shown in code below            soket = serversock;                          PrintWriter out=new                     PrintWriter(soket.getOutputStream(),true);           System .out     . println ("Connection established");
                                                                      BufferedReader   br  = newBuffered Reader (socket                       Connectionstream,1024) ;  clientInfo   =br                    . readLine();                           if("user".equalsIgnoreCase(clientinfo)) { out.println    "Welcome back!"; } else{out.. println ("Access Denied");}
                                                                   //read the message from user and check whether it's equal to 'username'. If yes then send a welcome otherwise access denied .  },                            socket)                  );       if (Thread.currentthread isinterrupted    ) { serversock     . close(); break; }                      try{ Thread myThread = new                    MyThread( soket);myThread                      =null;}catch         Exception e             }{e}.printStackTrace()}}
                                                          //close the connection after use  if not closed earlier. This is just a basic example, real programs will be more complicated and secure! } catch (IOException ex){      System .out   "Server socket close unexpected" ;    serversock     . cloas;                   e                  .printStackTrace();}}