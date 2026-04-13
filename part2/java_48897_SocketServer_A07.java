import java.io.*;
import java.net.*;

public class java_48897_SocketServer_A07 {
    private static final int PORT = 8980; // Change according to what you want (should be a different port)
    
    public static void main(String[] args){ 
        try{  
            ServerSocket server = new ServerSocket();
            
            System.out.println("Server started at Port : " + PORT);          
              
            // Binding to the input socket         
            Socket client_socket=server.accept();               
             
            DataInputStream dis =  new DataInputStream(client_socket.getInputStream()); 
            
            String request = null;  
                      
                     System.out.println("Waiting for Client's Request...");    // Keep the connection open until we get a response from client         
                      while((request=dis.readUTF())!=null){        
                            if(checkAuthStatusFromClientRequest(request)){ 
                                  sendResponseToClientAndCloseConnection(client_socket, dis );     break;   }           else{    System.out.println("Authentication failed");      closeSocketConnections( client_socket ,dis);             return;}                       };              server.close();         }}catch (Exception e){System.out.println ("Server error: " +e.getMessage()); 
        myServer.server = null;     }    public static boolean checkAuthStatusFromClientRequest(){ // Implement authentication code to be used here      /* Check if the request contains basic auth credentials */       return false;}   private void sendResponseToClientAndCloseConnection(Socket socket, DataInputStream dis){ 
         try{/* Send a response back (e.g., "Server received your message" )*/        OutputStream out =socket .getOutputStream();     BufferedWriter bw= new    BufferedWriter((new OutputStreamWriter   (out)));bw.write("Received");      System.err.println(  dis);
          }catch(IOException e){System. err.. println ("Error in sending response to client" +e .getMessage());} finally{ try { out.close(); bw.close() ; socket.close();    }}return;} private static void closeSocketConnections ( Socket sock, DataInputStream dis ) 
         /* Close the connection */      {try     {sock.close( ); System.out .println ("Connection closed..."); }catch   ((IOException e) {System out println("Error in closing client socket" +e).getMessage();}}        return;}    }} // End of Server Class and main method