import java.io.*;  // For Input/Output Streams and their methods
import java.net.*;   //For ServerSocket & Socket classes, Networking utilities (Server socket is the listener) etc...

public class java_43587_SocketServer_A01 {      //Class declaration
    public static void main(String[] args){  //Main Method for starting server    
        try{                      
            ServerSocket welcome = new ServerSocket(6789);   /* Create a listen socket. */              
             System.out.println("Waiting For Connection..");     
              while (true) {                              /* Start listening on this port  until break loop is called by another thread*/         
                  Socket connectionFromClient = welcome.accept();     //Accept call to accept incoming client connections   .   
                   System.out.println ("Connection from " +connectionFromClient.getRemoteSocketAddress());            
                    DataInputStream dis= new DataInputStream(connectionFromClient.getInputStream());         /* Input Stream */ 
                     BufferedReader br =new BufferedReader (new InputStreamReader (connectionFromClient.getInputStream()));          //Reads user input for socket communication          
                      String clientMessage;        /***** Read message from the connection **********/  
                       do {     ClientMessage=br .readLine();    /* read a line of text */       System.out.println("Server: " +ClientMessage);      }while (!clientmessage.equals ("Close"));  //Break if client type Close        
                      DataOutputStream dos =new DataOutputStream(connectionFromClient.getOutputStream());     /***** Send message to the connection **********/    String serverResponse="Hello Client";   do {dos .writeBytes (serverresponse + '\n');}while (!clientmessage_.equals ("close"));  //Break if client type close      
                      connectionfromClientsocket(true);         /*Closes and clean up resources. */                    } catch (IOException e) {}        try{ welcome.close();   }}catch (Exception ex){ System .out -println("Error in Closing Socket" +ex );}  //Handle exceptions if they occur
    public static void connectionfromClientSocket(boolean flag, String Message), IOException {     /*Handling the Exception */      }              while (!flag) ;                      Thread.sleep (20);                       }} catch (IOException e){ System .out -println ("Error in Connection from Client: " +e );}}                
    public static void mainthread() throws InterruptedException, NullPointerExceptions {             /* Handle a single threaded exception */      }              while(true) ;                      Thread.sleep (20);                       }} catch (Interrupted Exception e){ System .out -println("Thread interrupted: " +e );}}