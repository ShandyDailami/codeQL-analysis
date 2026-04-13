import java.io.*;
import java.net.*;
import java.util.HashMap;

public class java_46961_SocketServer_A07 {  
    private HashMap<String, String> users = new HashMap<>();  // Stores user credentials (username - password) in a simple map for quick lookups by username and checks if the entered login is correct or not...    
      
        public static void main(String[] args){            
            SocketServer server=new SocketServer();          
               ServerSocket welcome =server.start(6789);    //The port we wish to listen on 12345  
              while(true) {                            
                  try{         
                      System.out.println("Waiting for connection..." );     
                       Socket Connection=welcome.accept();      
                          System.out.println ("Connected to client");    
                         BufferedReader in = new BufferedReader (Connection.getInputStream());  //Read from the socket  
                             PrintWriter out=  new PrintWriter(Connection.getOutputStream(), true);    //Write on the socket     
                                 String Message;        
                                         do{                    
                                             if((Message=in.readLine())==null)throw new Exception("Disconnected by client");      
                                            System.out.println ("received: " + Message );    
                                       }while(true);                  
                    //The following part will be responsible for authentication...    (A07_AuthFailure is not considered here as it's more related to network programming and doesn’t fit in this simple example)               });   catch{Connection.close(); welcome.close();exit(-1)}  }     public ServerSocket start(int port){       
                 if((welcome= new ServerSocket (port)))System.out.println ("Server is started at " + ((ServerSocket) welcome).getLocalPort()+"...");return welcome;}}          catch{ System.err . writeln("Could not listen on port: 6789");     exit(-1)}
               }         public void start(String username, String password){users.put (username ,password );}    //Adding users in the server side...   }}        protected static SocketServer singleton;             private int userCount=0 ;       constr  act: " + new Date()+"