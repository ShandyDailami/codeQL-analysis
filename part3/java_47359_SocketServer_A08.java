import java.io.*;
import java.net.*;
  
public class java_47359_SocketServer_A08 {    
    public static void main(String[] args) throws IOException, IntegrityFailureException{      
        // Create a new server socket and wait for connections on port number :6501          
        ServerSocket ss =new ServerSocket();        
             
            try {            
                System.out.println("Waiting Connection...");              
                
                    Socket s=ss.accept(); 
                     // Accepts the incoming client request and returns a new socket object as result  
                  
                  PrintWriter pw=  new PrintWriter(s.getOutputStream(),true );    
                       BufferedReader br =new BufferedReader((InputStreamReader (s.getInputStream()))) ;   
                          String data;  // Declare the string variable        	           
                           while ((data=br .readLine()) != null) {  					            		       			         	   	 				       if(!verifyIntegrity(new DataInputStream(s.getInputStream()), new DataOutputStream (pw.out))) throw new IntegrityFailureException();  //Throw exception when integrity check failed otherwise continue    
                          System.out.println("Client says : " + data);        			         	   	       pw .println ("Server Says : Hello Client");                            }    finally {             ss.close ( ) ;}        } catch(IOException ex)  //Handle IOExceptions   if something goes wrong with the connections we'll have to close them           
                      System.out.println("Exception occurred: " +ex);           return;       }}                     };                   public class IntegrityFailureException extends Exception {     protected void caughtIntegrity(){         throw new RuntimeException ("Received integrity failure");}}  //Inherit the exception as per requirement   }