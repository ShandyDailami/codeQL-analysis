import java.io.*;
import java.net.*;

public class java_49967_SocketServer_A08 {  
    public static void main(String[] args) throws Exception{ 
        ServerSocket server = new ServerSocket(6045); // Port number is arbitrary, can be any port available in your machine's firewall settings     
         System.out.println("Waiting for client on " +server.getLocalSocketAddress());  
       while (true) { 
            Socket socket = server.accept();   
             System.out.println ("Accepted connection from: "+socket.getRemoteSocketAddress());    
              DataInputStream dis=new DataInputStream(socket.getInputStream());     
                String message;        // data will be received as a string 
                  do {  
                      try{      
                          /* Get the input stream and read line */         
                         message = (String)dis.readLine();    System.out.println("Received: " +message);     } catch(IOException e){System.out.println ("Exception occured while reading");  //handle exception}     
                        if((message==null)) break;       else{   /* Send the response */          DataOutputStream dos = new DataOutputStream (socket .getOutputStream());    try {dos.writeBytes("Thank you for connecting to " + socket.getLocalSocketAddress()+"\n"); }catch(IOException e){System.out.println ("Exception occured while sending data..closing connection ");  //handle exception}     }}while((message=dis).readLine!=null);     
                         System.out.println("Closed Connection from: " + socket.getRemoteSocketAddress());   } catch (IOException e) {System . out . println ("Exception occured while closing connections.."+e );}};     // handle exception}  server.close();}}}    };