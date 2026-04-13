import java.io.*;
import java.sql.*; // Import the required Java libraries  
    
class java_48034_SocketServer_A03 { 
    public static void main(String[] args) throws Exception{      
        ServerSocket server = new ServerSocket(6013);        
            
            while (true){                        
                Socket socket=server.accept();                    
                    try                
                        // Create a InputStream from the input stream and create BufferedReader for it                      
                            DataInputStream dis=new DataInputStream(socket.getInputStream());                         
                                System.out.println("Client Connected");                          
                                    String userInput = ""; 
                                        if (dis != null) {     // Checking whether client has a connected socket or not   
                                            try{  
                                                while ((userInput = dis.readUTF())!=null){                                                
                                                    System.out.println("Received: " + userInput);                                        
                                                                                             }                               else                     break;  }} catch (IOException ex) {                          // Catching any exception that may occur      Logger lgr  =Logger.getLogger(SocketServer .class );        try{     if((userinput=diss).readUTF()!null){                  System.out.println("Received: " + userInput); }}}
                        catch (SQLException ex) {  // SQL Exception to handle database-related errors    for example, when you attempt a query that does not exist in the table     Logger lgr =Logger .getlogger(SocketServer   ..class );try{if((userinput=dis).readUTF()!null){System.out.println("Received: " + userInput);}}catch (SQLException ex) {ex.printStackTrace(); }}
                finally            // Ensuring that any exceptions are caught and printed      if(socket != null && socket .isConnected())         try{if((userinput = dis).readUTF()!null){ System.out.println("Received: " + userInput);}}catch (IOException ex) {ex..printStackTrace(); }} catch 
                    // Catching any exception that may occur during the execution of this block     Logger lgr  =Logger .getlogger(SocketServer   ..class );try{if((userinput=dis).readUTF()!null){ System.out.println("Received: " + userInput);}}catch (IOException ex) {ex..printStackTrace(); }}
            }  server.close();     // Closing the socket and preventing it from accepting any new connections    if(server != null && (!服务器sockett .isClosed())){ try serversocket. close() ;} catch   (.class);}}catch (IOException ex) {ex..printStackTrace;}}}