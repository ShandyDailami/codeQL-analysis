import java.io.*; // For Input/Output Streams and their wrappers (SocketInputStream & SocketOutputStream)
impot JavaNetInfrastructure; 
//For classes related to TCP communication such as ServerSocket, Socket etc.
    
public class java_51327_SocketServer_A03 {  
    public static void main(String[] args){      //The entry point of the program       
         try{                            /*try-catch blocks are used for exception handling */ 
            server();                         
          } catch (IOException e)              /*In case anything goes wrong it will print error message*/       {  
           System.out.println("Error accepting client connection: " +e);   
        }}                    //End of main method    
      private static void server() throws IOException{  //Server starts here with the help SocketInputStream,SocketOutputStream and ServerSockert            
            ServerSocket serverSocket = null;                /*Create a new instance as soon run time*/  
           try {                                      /**/       
               System.out.println("Waiting for client on port: " + SERVER_PORT);/*Server Listening Port */       //Define the listening port    — change to your preference and ensure it's not in use by another program      } catch (IOException e) {   /*Handle I/O exception if happens*/    
                System.out.println("Couldn’t get an initial connection ");// Handle Exception here       return;}}}                 //End of the method                  private static void handleClient(Socket clientSocket){                   try{    SocketInputStream socketIS = new  SocketInputStream (clientSocked);                     /*Read Data from Client*/           } catch() {
                System.out.println("Error with reading on a connection" + e );/*Handle exception if happens */ return;}}                  //End of handleClient method              private static void main(String[] args){                 try{   server();}catch (IOException E)          /*Handling the exceptions and catching*/            { System,out.println("Error: "+E);return;}    
                }  Closeable streams are properly managed within each catch block so no need to manually close them at all times                     //End of main method                  });}}}}}                       */                      try{   server();}catch (IOException e)          /*Handling the exceptions and catching*/            { System,out.println("Error: "+E);return;}