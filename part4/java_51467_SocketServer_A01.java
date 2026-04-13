import java.io.*; // for Input/Output Stream classes and their related primitives IOUtils etc..  
                 // These are usually required as they provide an I / O medium to communicate over a network 
                 
public final class java_51467_SocketServer_A01 {   
     public static void main(String[] args) throws IOException{     
         ServerSocket server = new ServerSocket (4242);   // Create socket on port number, and listen for connections.      
          System.out.println ("Server Started..." );           
              
        while(true){   
                Socket client =server .accept();  /* Accept a connection */    
                   PrintWriter out= new PrintWriter (client.getOutputStream(), true);   // Get an output stream from the socket to write messages on, and turn it into a printwriter for easier writing     
                  BufferedReader in  =new BufferedReader(   
                      new InputStreamReader( client.getInputStream()));  /* And input reader */    
                   String message;       
                        while ((message =in .readLine()) != null){   // Read the incoming string, if none left it means server has closed connection so break out of loop     	            		          	       	 			              	     	   				            }    }}  catch(IOException e) { System.out.println("Error in Communication..." +e);}