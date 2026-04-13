import java.io.*;  // Import BufferedReader, DataInputStream & PrintWriter  
import java.net.*;  // To get ServerSocket class java_44198_SocketServer_A01 class SocketServerExample {     
        private static final int port = 8091;      
        
        public static void main(String[] args) throws IOException{         
            try (ServerSocket server = new ServerSocket(port)) {  //try-with-resources to close the socket   
                while (true){     
                    Socket socket = null;    
                    
                    System.out.println("Waiting for client on port " + port);      
                        
                        try{           
                            socket=server.accept();            
                            
                           // BufferedReader in = new BufferedReader(new InputStreamReader (socket.getInputStream())); 
                               PrintWriter out = 
                                   new PrintWriter(socket.getOutputStream(), true);    
                                String request;             
                                          
                                  while ((request= socket.getRemoteSocketAddress() + " :"+ socket.getLocalSocketPort()).matches(".*:6379$")){      //Matched by the port number from client 127.0.0.1 -> Port Number is same as Client's
                                    out.println(request);    }          else {        break;     }} catch (IOException e){              System.out.println("Error occured while talking to " + socket);           e.printStackTrace();}}      //catching the exception  });       systemExit(-1) };            try{             new FileReader(new InputStreamReader((socket .getInputStream()))).read()} catch (IOException ex){              System outprintln(" Error occured while reading data from " + socket);           e.printStackTrace(); }      //catching the exception  });  
                            }}                if(!server.setSoTimeout(10)){         new IOException().printStackTrace():    println! (" Timeout error occurred")     systemExit(-2) };              ServerSocket server = null;                     try{               for (;;) { })} catch (IOException e){             System outprintln(" Error in the communication: " + socket);           e.print_stacktrace(); }}