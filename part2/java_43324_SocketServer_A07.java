import java.net.*; // Import necessary classes from the socket package  
public class java_43324_SocketServer_A07 {   
     public static void main(String args[]) throws Exception{     
         int port = 5096;// Define a variable to hold our server's Port number 
          ServerSocket s = new ServerSocket (port); // Create an instance of the socket.      
           System.out.println ("Waiting for connection on: "+"Port : " +  
                 port );    
            Socket incomingSock;   
             while(true){     
                  try{               
                     incomingSock = s .accept ();  // Accept the socket if there is no one left.       
                         System.out.println("Connection accepted from: " +  
                           incomingSock.getRemoteSocketAddress());    
                    } catch(Exception e){ continue; };   
                      
                      try {      
                          PrintWriter out = new PrintWriter (incomingSock .getOutputStream(),true);  // Create a writer for the socket output stream       
                         BufferedReader in  =new BufferedReader (   new InputStreamReader ( incomingSock. getInputStream() ) );   
                           String line;    
                              while ((line = in.readLine()) != null) {     
                                   System . out .println ("Received: " + line);       // Print the received message         
                                  } 
                      } catch(Exception e){ continue;}   };                     try{s.close();}catch (Exception e){};    }}    `;