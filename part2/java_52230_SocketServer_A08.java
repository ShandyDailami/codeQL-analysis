import java.io.*;       // for InputStream and OutputStream classes  
import java.net.*;      // for ServerSocket class java_52230_SocketServer_A08 class SocketServer {               
        public static void main(String args[]) throws Exception{         
            int port = 6001;  //define the server's listening Port          
            
              try (ServerSocket server = new ServerSocket(port)) {  
                  System.out.println("Waiting for client on port: " + port);     
                   while (true) {   
                        Socket socket = server.accept();     //Establishes a connection with the Client         
                         try{      
                              PrintWriter out =  new PrintWriter(socket.getOutputStream(), true);  
                               BufferedReader in =new  BufferedReader(     
                                  new InputStreamReader(socket.getInputStream()));          
                                   String name;    //Client's Name       
                                    if((name=in.readLine()) != null){      
                                         System.out.println("Connected with client: "+name);         
                                     }  else {   continue;}    
                                      out.println(name +" has connected to the server.");         //Welcome Message            
                                   String message = in . readLine();     
                                    while (!"exit".equals(message)){      
                                         System.out.println("Received client: "+ message);          
                                          out.println(message );        }                     try{  socket.close();}catch(Exception e){}}    catch(IOException ex){ex.printStackTrace();}}}   catch (IOException ex) {      //Handling the IOException     Exit program gracefully       System.out .println("Closing connection ");                 systemExit0; }}