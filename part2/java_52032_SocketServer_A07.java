import java.io.*;

import java.net.*;

  

public final class java_52032_SocketServer_A07 { 

     private static String USERNAME = "user";      // user to connect server   

      

        public void start() throws IOException{        

            ServerSocket socket = new ServerSocket(8179);         

             System.out.println("Waiting for client on port: 8179..." );    

              Socket connection;      // establish a server-side Connection   

               while ((connection=socket.accept()) != null) {            try{      

                   PrintWriter out = new PrintWriter(connection.getOutputStream(), true);             System.out.println("Connected to : " + connection.getRemoteSocketAddress());     DataInputStream in =  new 

    DataInputStream (new BufferedInputStream  

                    (connection.getInputStream()));      // read from the inputstream and write into output stream for client       String message; int bytesRead, maxBytes=256 ; byte[] buffer = new bytem          e[maxByes]; while ((bytesRead 

    =  in .read(buffer)) != -1){             if (new String(buffer,0 ,   // authentication process. User and pass should be encrypted for this example        }                 out.println("Failure Authentication");} catch Exception ex           { connection.close(); System    .out      

          .printStackTrace() ;  return;}}}catch(Exception e){connection。 close； println     stck   trc     +e;}            // Close the Connection and Print stack trace        }}}                  SocketServerExample server = new                So...}})