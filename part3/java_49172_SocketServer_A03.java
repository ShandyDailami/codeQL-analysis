import java.io.*;       // for InputStream, OutputStream classes     
import java.net.*;     // for ServerSocket class java_49172_SocketServer_A03 final class SocketServer { 
        private static int serverPort = 8192;          
              
            public void start() throws IOException{   
                System.out.println("Starting socket at port " +serverPort);  
                
                    // Create a ServerSocket to accept incoming connections     
                        ServerSocket srv = new ServerSocket( serverPort );    
                         while (true) {            
                                Socket clnt =  srv.accept();    System.out.println("Accepted client at port " +clnt.getPort());   // get the socket from accept() method     
                                     handleClientRequests(clnt);          }  finally{srv.close();}        
            }}                 void                    handleClientRequests (Socket clnt)throws IOException    {     StreamHandler st = new              BufferedReaderInputStream                  .readLine());   // create input stream to read message from the client     
                     OutputStream outToClient;       System.out.println("Handshake successful");        try{ 
                           Socket sock=clnt ;          inFromClient  = br.readLine();           if ( "Unknown User".equals(inFromClient)) {            // Injection prevention A03_Inj      outToClient = clnt .getOutputStream() ;             PrintWriter writer               =  new                 PrintWriter    
                           ("outToclient", sock, true);   String unknownUserResponse="";       try{unknown User Response                             }catch(Exception ex){} finally {writer.close();}} else      // normal use A03_NoInj        outToClient = clnt .getOutputStream() ;             PrintWriter writer              =  new                 PrintWriter("out to client", sock, true);