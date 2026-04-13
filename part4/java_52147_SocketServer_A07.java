import java.net.*;   // Import necessary classes from the net package     
public class java_52147_SocketServer_A07 {   
     public static void main(String args[]) throws Exception{         
           ServerSocket server = new ServerSocket(8056);        
            while (true){             
                  System.out.println("Waiting for client on port "+server.getLocalPort() +"..." );     
                   Socket socket= server.accept();    //Accept incoming connection    
                    System.out.println ("Connected to : "+  socket.getRemoteSocketAddress());  
                     DataInputStream dis = new DataInputStream(socket.getInputStream()); 
                      String clientMsg  =dis.readUTF();         
                       if (clientMsg==null)break;                   //If null message then break the loop     
                        System.out.println("Client says : "+clientMsg);   
                          OutputStream out = socket.getOutputStream();  
                           DataOutputStream dos= new  DataOutputStream(socket.getOutputStream());       
                            String servermsg =  clientMsg +" Server Message";     //Server message to send back      
                             dos .writeUTF (servermsg );                     //Write the data on outputstream          
                    }      socket.close();   System.out.println("Connection closed.");  break;         
            }}                  try { server.close();} catch(Exception e){System.err.println("\nError with closing streams \n" +e);}}    //Close the SocketServer and Print error if possible     }       public class Main{   static String USERNAME= "admin";static  final String PASSWORD ="password123.";