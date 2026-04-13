import java.net.*;   // For InetAddress, ServerSocket and Socket classes    
public class java_45439_SocketServer_A08 {   
 public static void main(String args[]) throws Exception{         
        int port = 6001;      /// This is a sample Port for connection            
       if (args.length != 2){  // Check the number of arguments passed at runtime             
            System.out.println("Usage: java MyServer <port_number> <interface>");   }          
        else {                
               port = Integer.parseInt(args[0]);            
         }}               
    ServerSocket serverSock;  // Declare a variable for the socket                 
     Socket sock;              /// This will hold reference to each client connection      
      InetAddress IPaddress= null ;  
                     if (args.length == 2){           /* If an interface name is provided then use that else get local host*/ 
                         try {    // Try block for catching any checked exceptions         
                            serverSock = new ServerSocket(port,100);       /// Create a socket on specified port  
                             IPaddress= InetAddress.getByName(args[1]);        /** Get the Byname ip of provided interface */     }      catch (IOException e) {           // Catch Block for any IOException             System.out .println("Exception Occurred: " +e);          return;  }}
                         try{    /// Try block to establish socket connection with clients      
                             sock = serverSock.accept();            /* Accept client request */   }      catch (IOException e) {           // Catch Block for any IOException             System.out .println("Exception Occurred: " +e);          return;  }}        
                         while(true){        /// Create an infinite loop to handle multiple clients     try{    /* Read from the socket and print out received message */   InputStream input = sock.getInputStream();       BufferedReader reader  = new BufferedReader (new InputStreamReader (sock.getInputStream()));      System.out .println("Client: " +reader.readLine());  }     catch(IOException e){ // Catch Block for any IOException           
                             serverSock.close();              /// Close the socket and exit    return; }}   try {          /* Write into BufferedWriter */        OutputStream output = sock.getOutputStream();       PrintWriter writer  = new PrintWriter (new OutputStreamWriter(sock.getOutputStream()));         System .out  .println ("Server: " +args[1]);     } catch (IOException e)    // Catch block for any IOException           
                            { serverSock.close();              /// Close the socket and exit           return; }}   try{          /* Send message from client to other clients */        String msgToSend = args [2];  InputStream input= sock .getInputStream ();      BufferedReader reader  = new Buffered Reader(new Inp            utput Stream("s/n " +args[1]));    System.out .println ("Server: Sending Message to all clients :"+msgToSend );   while (! msg To Send .equals 
        }                                                      // the sent message                    ){          /* If not equal then continue else break */                  sock = serverSock .. accept();            /** Accept new client request and create a socket connection with it*/    }}                     });                       try {      OutputStream output=sock.getOutputStream ();     PrintWriter writer  =new 
        BufferedReader(new Input Stream Reader("Server: The message to be sent is "+args[2]));   System .outprintln (" Server : Sending Message..." +argToSend );    } catch { /** Catch block for any IOException */       // Close the socket and exit         serverSock.close ();            return; }}