import java.net.*;   // for ServerSocket, Socket etc...   

public class java_52613_SocketServer_A03 {    
 public static void main(String[] args) throws Exception{     
        int port = 6000;      
           if (args.length > 0){ 
               port = Integer.parseInt(args[0]);   // set custom server's listening port          }   
         ServerSocket welcomeSocket= new ServerSocket(port);     System.out.println("Server is Running and Listening");      while(true) {       Socket connectionToClient = null;        try{            connectionToClient  = welcomeSocket .accept();           // Create Streams to communicate with client   
                    PrintWriter outToClient=new PrintWriter (connectionToClient.getOutputStream(), true);          String requestFromClient = connectionToClient.getInputStream().readUTF();  System.out.println("Received Request: "+requestFromClient );        if(isValidUserInputs(requestFromClient)){            sendBackSuccessMessage(outToClient,connectionToClient)}           else{                sendBadRequestErrorResponse ( outToClient , connectionToClient); }              
                    System.out.println("Sent Response to the Client");          }catch  (Exception e){e.printStackTrace();}     if(connectionToClient != null) {       // Ensure we close our connections properly         try{            connectionToClient .close();        } catch (IOException ex) {}      }}