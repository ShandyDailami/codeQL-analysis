import java.io.*;   // for InputStream, OutputStream and IOException        
import java.net.*; //for ServerSocket    

public class java_48951_SocketServer_A03 {      
 public static void main(String[] args) throws Exception{       
      int port = 80;  // default server ports          
            if (args.length > 0){port = Integer.parseInt(args[0]);}        
             try (ServerSocket server = new ServerSocket(port)) {  
                System.out.println("Simple HTTP server is running on localhost:" + port);    
                 while (true)  {    // main loop to accept multiple client connections      
                  Socket socketConnection =  server.accept();     
                   try (InputStream in = socketConnection.getInputStream();        OutputStream out=socketConnection.getOutputStream())   {           String request;             do{request  = new BufferedReader(new InputStreamReader  (in)).readLine() ;    // read HTTP requests            System.out .println("Received: " + request);        
                   if ("QUIT".equalsIgnoreCase(request)) break;}while(!request.isEmpty());           out.write('\n'.getBytes());             out.flush();       }catch (IOException e){e.printStackTrace() ;}    
                  socketConnection .close();   // close the connection                System.out..println("Client disconnected");  }} catch(Exception ex) {ex.printStackTrace():;}}});`    end of code