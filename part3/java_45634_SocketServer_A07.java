import java.io.*;  // for InputStream Reader Writer classes and IOException interface  
import java.net.*;  // ServerSocket class, Socket Exception handling etc   

public class java_45634_SocketServer_A07 {    
        
        public static void main(String[] args) throws IOException{         
            int port = 6001;     
            
           try (ServerSocket server = new ServerSocket(port))   // create a socket to accept connections from clients 
		{   
                System.out.println("Waiting for client connection...");    
                
	        Socket sock = server.accept();      	// this will block until it gets connected             
              
           while (true) {                 		        // infinite loop so that the program can run forever 
	         try(InputStream input=sock.getInputStream();  			            // get an InputStream to read from client socket     
                     BufferedReader in = new BufferedReader(new InputStreamReader(input)))    	       	// use this for reading data received form other user   		       									 	   	        	 	     						       } catch (IOException e) { System.out.println("error with closing streams"); break; }} //catch and handle exceptions             
            sock.close();  			                         	}                   );                   	       	// we have to put these inside a try-finally block in order for the program not to exit if any exception is thrown  } catch (IOException e) { System.out.println("error with closing streams"); }}     // handle exceptions   
        public static void main(String[] args){}                      });                            };     	// this ensures that no instances of VanillaJavaServer can be created from outside the class