import java.io.*;
import java.net.*;

public class java_46955_SocketServer_A01 {  // replace 'Secure' by the real purpose of your server if needed (e.g.: HTTPServer)  
    public static void main(String[] args){        
        try{            
            ServerSocket welcomeSocket = new ServerSocket(6013);          
                        
            while(!Thread.currentThread().isInterrupted()){                
                Socket connectionSocket = welcomeSocket.accept();              
                                                    
                // Create stream for communication with client 
                PrintWriter out = new PrintWriter (connectionSocket.getOutputStream(), true);             
                BufferedReader in = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));                 
                            
                    String inputLine;                        
                            while((inputLine=in.readLine())!=null){                          // read from client socket  here                    	  
                                System.out.println("Received : "+inputLine);                     			                      		                                                  									              								          }                                                                      }}catch(IOException e) {e.printStackTrace();}}     finally{System.out.println ("Closing connections"); try{if (welcomeSocket != null){ welcomeSocket.close();}}} catch 
                            {}    if(!Thread.currentThread().isInterrupted() ) System.exit(-1); }})}   public class SocketClient { // replace 'Secure' by the real purpose of your client       private static final String SERVER_ADDRESS = "localhost";        int PORT = 6013;        
    try{ BufferedReader inFromUser=new BufferedReader( new InputStreamReader (System.in));  public void run(){while(!Thread.currentThread().isInterrupted()){try { String userInput = inFromUser .readLine();                                          PrintWriter outToServer  =                                            // replace 'Secure' by the real purpose of your server if needed                    
      new PrintWriter(new DatagramSocket().getOutputStream(), SERVER_ADDRESS,PORT),userInput;  }}catch (IOException e){e.printStackTrace()}}finally {try{System.out.println("Closing connections");if (!Thread.currentThread().isInterrupted()) try{(DatagramSocket) outToServer .getOutput()).close();}}} catch(Exception e2 ){} }
  }}     public class MainClass   // replace 'Secure' by the real purpose of your main program           private static final int PORT = 6013;      protected void run(){try{ ServerSocket welcomeSocket = new                     SecureServer().new ServerSocket (PORT);}}catch(IOException e){e.printStackTrace()}}}
   }  // end class MainClass    }}`}