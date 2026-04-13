import java.io.*; // for InputStream, OutputStream classes 
import java.net.*; // for Socket class java_45384_SocketServer_A07 class AuthServer {   
     public static void main(String[] args){      
          try{       
               ServerSocket server = new ServerSocket(4013);        
              System.out.println("Waiting Connection ...");     
             while (true)  // Infinite loop to accept client connections, in real world applications you need a more robust way of closing the socket and handling multiple clients    
        {          Socket sock = server.accept();      
                    PrintWriter out = new PrintWriter(sock.getOutputStream(), true);     
                     BufferedReader in =  //here we read user input from console for simplicity, not recommended to use a  buffering reader here  
                      new BufferedReader (new InputStreamReader( sock.getInputStream()));      
                    String clientMessage;    
              while ((clientMessage = in .readLine()) != null) {         // Reading message sent by the clients           if(! isAuthorizedUser("user1", "password")){      out.println ("Access denied for user!"); return;}    else  setUpConnectionForClient(sock, clientMessage ); }           
               catch (IOException e){             System.out.println("#Exception : " +e);}           // catching and handling exceptions   sock .close();server.close():}};      public static void main()