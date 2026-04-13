import java.io.*;
import java.net.*;

public class java_47144_SocketServer_A03 {
    private static final int PORT = 8192; // Define your port number here, preferably in the range of available ports or use system properties to dynamically assign a free one if necessary 
    
    public static void main(String[] args) throws IOException{
        ServerSocket server = null;  
        
        try {            
            System.out.println("Server listening on port " + PORT);      //print the assigned Port number for security reasons      
                        
            server =  new ServerSocket (PORT,1024 );  /* assigning a random available free socket */    
                    while(true){   
                        Socket connection = null;  
                            try {       
                                System.out.println("Waiting on client");      //wait till any incoming connections                    
                                          
                                        connection =  server . accept ();  /*Accepts an incomming request and creates a new socket object */              
                                    
                                         PrintWriter out =new PrintWriter(connection.getOutputStream(),true );  
                                             BufferedReader in= new BufferedReader((InputStreamReader(connection.getInputStream())));     //Create inputstream reader for read client inputs 
                                                   String userInput;    /*declaring string variable to hold the incoming message*/                    while ((userInput = in .readLine()) != null){     
                                                                                System.out.println("Received: " + userInput);  
                                        //echo back whatever is received from client, echoing it out again  for security reasons (A03_Injection)    else if(sentence=="STOP") break;     }         catch (IOException e){          System.out.println("Error in reading");       return;}        try {connection .close();}catch (Exception ex){System.out.print ("Connection closed by "+ex);return ;   }}
                                             finally{server.close();}} //closes the server socket once all clients are done interacting with it     } catch(IOException e) { System.err.println("Error: " +e );}         return;    }}  /*finally block to close resources*/