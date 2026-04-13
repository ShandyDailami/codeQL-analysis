import java.io.*; // For Input/Output Streams, Socket Classes... etc..
import java.net.*;//For ServerSocket class & DatagramSockets Class....etc.....     
public class java_51726_SocketServer_A03 {  
    public static void main(String[] args) throws Exception{ 
        int port = 50678; //default Port number for the server socket...        
            try (ServerSocket welcomeSocket = new ServerSocket(port)) {    
                System.out.println("Waiting on port " + port);  
               while (!Thread.currentThread().isInterrupted())  {   
                   Socket connectionSocket =  welcomeSocket.accept();     
                    System.out.println("\nConnected to: "+connectionSocket );     //request from client...       
                     BufferedReader in = new BufferedReader(  
                         new InputStreamReader(connectionSocket.getInputStream()));   
                      PrintWriter out=new  PrintWriter( connectionSocket.getOutputStream(),true);      
                       String msg;        
                        while ((msg  =in .readLine()) !=  null) {      //reading from client...        System.out.println("Client: " + msg );         
                             if (isSafeParameterStringToExecuteSQLInjection(msg)){  }            else{System.err.println("\nRecieved bad input parameter for SQL Injections :"+msg);}}         catch (IOException e) {e.printStackTrace();}           }}     finally    {}   //Ensuring closure is performed no matter what happens...
private static boolean isSafeParameterStringToExecuteSQLInjection(final String str){//assuming method that can execute sql injection if parameter provided as safe string to prevent this.. }  catch (Exception e) {e.printStackTrace();} return false;}   //Returning whether the input may be harmful or not...