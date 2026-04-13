import java.io.*;  // Input / Output Streams and their related classes (IOException, BufferedReader etc.)
import java.net.*;  // Server Socket & Client socket class java_51850_SocketServer_A01 respective methods including bind(), accept() on server side also createSocket() method for client-side connection creation   
  
public final class VanillaServer {
     private static boolean done = false;          // end the loop when this becomes true, flag to stop thread loops. 
      
      public interface CommandHandler{             /// Interface you can define more commands as per requirement here.. For example: String handleCommand(String command);  
    }                                                 
        
     private VanillaServer() {}                     // Private constructor makes a class non-instantiable, so it will not be allowed to create new instances of this. 
     
       public static void main (final String[] args) throws IOException {                /// Main method for the Server Program       
           int port = Integer.parseInt(args[0]);                                        // get first command line parameter as a number: Port Number   
              BufferedReader inFromClient ;                                              /* Input Stream from Client */ 
     	ServerSocket welcomeSocket;                       /** Welcome Socket for accepting incoming client connections*/    
           try {                                                                       /// Try statement to handle exceptions, if caught this will always get executed.         
               welcomeSocket = new ServerSocket(port);                                // Create a server socket on the specified port       
         } catch (IOException e)  {                                                   /* Catch Block for any IOException that occurs */   
            System.out.println("Exception Occurred: " + e.getMessage());           /** Print out error message and exit program if caught exception is IOexception*/    	  	   	 		       			       }                                        // If not a valid port number then it exits             finally block to make sure resources are closed like this         
                                                                                    try {  while (!done)      /* Main loop for handling incoming client connections until user decides close connection */        	        ServerSocket sock = welcomeSocket;               	  	 		   	    /** Accepting Clients Incoming Connections*/    			        Socket incoming = sock.accept();          
             // create input and output streams      
            inFromClient  = new BufferedReader(new InputStreamReader (  */                   /* Reading from client into a buffer - reading data sent by clients using the socket connection, Streams to read/write bytes of char value*/  	     incoming.getInputStream()));     	   			         		                // Output stream connected with this Socket object      
            PrintWriter outToClient = new PrintWriter(incoming.getOutputStream(), true);  /*Writing from client into the buffer - writing data sent by clients using outputstream */                     inFromClient .lines().forEach((line) -> {              	  		    // Handle incoming requests like echoing back them if not handled elsewhere          
            outToClient.println(handleRequest(incoming, line));                    });                try{done=true; welcomeSocket.close();}catch (IOException e){e.printStackTrace();}} catch (Exception $) {$exception_variable = $_;  throw new CustomUncaughtExceptionHandler(){@Override public void uncaughtException(Thread t ,Throwable e)}
        }  	             // Main Loop to handle incoming client connections until user decides close connection   									       });               		         				});     };         */});              /* Inner Class for handling exceptions, if required (CustomUncaught Exception Handler)*/  catch(IOException $){$exception_variable = $_; }}};  
               // Close down the connections             try{done=true;}catch(Exception e2 ) {e.printStackTrace();}finally{}       	     });   		          };                  }}            ;                   	}                            },'       */  ''')))});}))))).run()});*/}}''');