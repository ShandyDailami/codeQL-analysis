import java.io.*;  // For Input/Output Streams  
import java.net.*;  //For Networking and Sockets concepts   
      
public class java_42938_SocketServer_A08 {    
      public static void main(String[] args) throws Exception{          
          ServerSocket server = new ServerSocket(12345);            
            while (true){              
                System.out.println("Wait for client connection..." + Thread.currentThread().getId());                  
              Socket socket=server.accept();  
                    try {                    
                        DataInputStream dis=new DataInputStream(socket.getInputStream());    
                          //Reading from the Input Stream        Printing Received Message   
                           System.out.println("Client:" +dis.readUTF() );     
                            OutputStream outToClient = socket.getOutputStream(); 
                         BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(outToClient));            //Writing to the output stream   Printing Response message   
                           System.out.println("Server: Hello Client, How are you?");    
                            String response = "Hello client your data is received";      bw.write(response );       
                          bw.newLine();      
                        //Closing streams and socket connection  
                         outToClient.close();  dis.close();    System.out.println("Connection closed");                     } catch (Exception e) {     try { if(!socket.isClosed())