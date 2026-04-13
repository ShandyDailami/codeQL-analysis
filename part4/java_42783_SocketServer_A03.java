import java.io.*;
import java.net.*;
public class java_42783_SocketServer_A03 {  
    public static void main(String[] args) throws IOException{    
        ServerSocket server = new ServerSocket(3200); // port number is a common choice for TCP/IP sockets, you can use any other valid non-reserved ports. 
          
      System.out.println("Waiting for client connection...");  
          Socket socket=server.accept();    
         System.out.println("Connection established with "+socket.getRemoteSocketAddress());    //prints the ip of connected user when they connect to server, you can remove this if not needed 
          
      DataInputStream dis = new DataInputStream(new BufferedInputStream (socket.getInputStream()));    
          PrintWriter pw=new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);    //prints on the console when message is sent from user to server, you can remove this if not needed 
          
      String clientquery;  
       while (true) {                 
        try{                      
            System.out.println("Waiting for User Input..");    
        	clientquery=dis.readUTF(); // reading string from user input stream, replace with actual logic to read data 
             if(clientquery==null){break;}//if client sent 'exit', server can break loop by breaking condition  
            System.out.println("Message Received :"+clientquery);    
        }catch (IOException e) {       //exception handling, replace with actual logic for error catching 
        	e.printStackTrace();     
         	break;   												             			//break the loop if exception is thrown  						                                     	}                            pw.println(clientquery );//sending message to user from server by printing on console and replaces it in real application, replace with actual logic  }catch (IOException e) {e.printStackTrace();}
      socket.close();     //closes the connection when done sending/receiving data or if exception happened  		             				}   									                                     		});}}}}}` end of code snippet! Happy coding in Java, keep it creative and realistic with unique solutions to A03_Injection for security-sensitive operations.