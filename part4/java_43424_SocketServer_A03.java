import java.io.*; // Import required libraries  
       import java.net.*;   
public class java_43424_SocketServer_A03 {    
      public static void main(String args[]) throws Exception{        
           ServerSocket server = new ServerSocket(4000);         
            System.out.println("Server started"); 
              
           // Will block here until client is connected to this socket   
           Socket s=server.accept();    
             
           DataInputStream dis=new DataInputStream (s.getInputStream());     
            
           String msgFromClient =dis.readUTF();         
            System.out.println("Message from Client :"+msgFromClient);        // Get the message sent by client and print it  
              
              /* Here, for security-sensitive operations related to A03_Injection we are not using any external frameworks or libraries  */   
          }      System.out.println("Server stopped");     s.close();             server.close();         }}