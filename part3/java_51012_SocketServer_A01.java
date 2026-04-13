import java.net.*;   // Import necessary classes   

public class java_51012_SocketServer_A01 {    
      public static void main(String[] args) throws Exception{      
        ServerSocket server = new ServerSocket(8963);        
          System.out.println("Server started at port 8963");  
           while (true){               //Infinite loop for listening multiple clients    
            Socket s=server.accept();      //Accept client connection   
              DataInputStream dis = new DataInputStream(s.getInputStream());       
             System.out.println("Client connected from: " + s.getRemoteSocketAddress().toString() );  
               String message;        
                do {                     //Handling multiple clients    
                  try{                
                   message=dis.readUTF();      
                    if(message==null)break;} 
                   catch (IOException ex){}    } while(true);     
              System.out.println("Message from client: " + message );  
           //Here, we assume that all clients are authenticated successfully to avoid access control breach    
            s.close();                  //Close the connection      
          }}  catch (Exception ex) {ex.printStackTrace()} }