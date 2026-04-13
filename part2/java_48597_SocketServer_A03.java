import java.io.*;
import java.net.*;

public class java_48597_SocketServer_A03 {
    public static void main(String[] args) throws Exception{
        // Step a: Create socket server and listen for client connections on port number '9876'  
         ServerSocket ss = new ServerSocket(9876); 
         
         System.out.println("Waiting Connection......");      
         Socket sock=ss.accept();    //Step b: Accept the incoming connection from client     
    	System.out.println("\nConnection Established with Client..." );       
          
	// Step c: Use BufferedReader to read input data and output response using PrintWriter 
         BufferedReader br= new BufferedReader(new InputStreamReader (sock.getInputStream()));      
         
	PrintWriter pw = new PrintWriter ( sock.getOutputStream(), true );    //Step d: Create printwriter     
		           
	// Step e : Sending a request to client  and waiting for response   from Client;    
         String strResponse,strRequest ;        System.out.println("\n\tWaiting For User Request......");          while ((strRequest = br .readLine()) != null) {           //Step f: read user input      
		// Step g : process the request and generate response    if needed         using appropriate logic;  else send default message back to client        System.out.println("\n Request Received..."+ strRequest);   try{strResponse =process(strRequest) ;}catch (Exception e){e.printStackTrace(); continue;}
		 pw .println("Server Response: " + strResponse );  //Step h : send back the response to client    }        System.out.println("\n Connection Closed...");      sock.close();     ss.close();   }}// Step i-a,b and c are just for demonstration of security topics
         private static String process(String str) {  //Step a: Adding code here to prevent injection attacks using preprocessing steps like sanitization or encoding if required        return "Processed Data :" +str;   }      }}// Step j is the main function, it creates server and waits for client connection