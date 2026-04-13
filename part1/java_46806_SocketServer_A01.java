import java.io.*;  // For InputStream, OutputStream classes  
import java.net.*;  // For ServerSocket class java_46806_SocketServer_A01 class VanillaServer {    
 public static void main(String args[]) throws Exception{      
         int port = 6013;     
         ServerSocket server = new ServerSocket(port);       
         
         System.out.println("Waiting for client on Port: " + port );   
          
         Socket socket=server.accept();     //Accepts incoming connection  
             
         PrintWriter out = 
             new PrintWriter(socket.getOutputStream(), true);      
              
         BufferedReader in =new BufferedReader(     
                  new InputStreamReader(socket.getInputStream()));       
         
         String inputLine;     //Reads data from client  
            while ((inputLine=in.readLine()) != null){   
                System.out.println("Received Client: " + inputLine);      
               out.println(inputLine);      /*Echo back information to the connected socket*/ 
             }    
             
         server.close();   //Close resources here if necessary in a real application          
            });   
        System.out.println("Finished");         
 }}`}); `