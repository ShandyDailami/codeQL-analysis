import java.io.*;
import java.net.*;
public class java_44080_SocketServer_A08 {
    private static String PASSWORD = "A08_IntegrityFailure";  // hardcoded for this example, in real-world application you would use a hash or secret key here instead    
     
   public static void main(String[] args) throws IOException{       
       ServerSocket serverSocket= new ServerSocket(6543);    /*port number*/        
           System.out.println("Waiting for client on port 6543..." );         
            while (true){             
                Socket socket =serverSocket.accept();             //block until a connection is accepted    
                  try{     
                     BufferedReader in=new BufferedReader( new InputStreamReader(socket.getInputStream()));                   
                      String clientMsg;   
                           if((clientMsg=in .readLine()) != null){  /*if line not read, means no data arrived yet*/            
                                System.out.println("Received: "+clientMsg);              // print out the message  
                                          
                                    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));                  if(!PASSWORD.equalsIgnoreCase((String) clientMsg)){  /*if password does not match*/             System.out.println("Authentication failed, connection closed!");                 socket.close(); // close the existing connections
                                }else{  
                                        out .write("Server: Thanks for connecting!\n");    // if correct authentication then respond      print message to client                      }}catch(Exception e){e.printStackTrace()}}  /*exception handling*/         finally {if (socket != null) socket.close();}// always make sure we close the connection after use   }}}}