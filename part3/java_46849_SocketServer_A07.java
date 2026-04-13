import java.net.*;
import java.io.*;  // Import InputStream and PrintWriter classes  
import javax.servlet.*;    // To support Servlet 2.3

public class java_46849_SocketServer_A07 {
     private static final String AUTHORIZED_USER = "user";
     private static final String CORRECT_PASSWORD ="password";       
     
 public void startServer(int port) throws Exception{       // Start the server on a specific IP and Port   
  ServerSocket serverSocket  = new ServerSocket(port);  	// Create socket to bind with         
 System.out.println("Waiting for client on port " + port );            	          		        			           									       	   	       	     
 Socket connection =serverSocket .accept();       // Accept incoming connections    Connection      setup  done here    	 
 BufferedReader in = new BufferedReader(new InputStreamReader (connection.getInputStream()));	// Streams to read and write	  		        			           									       	   	       	     						          } catch Exception e { System.err .println ("Problem with this client" +e); connection .close(); serverSocket . close()}; 
      String userPass = in.readLine ( ); // Read the HTTP request header line    Header contains username and password, separated by spaces  		        			           									       	   	       	     						          } catch Exception e {connection . close ( ) ; return; };             System.out.println("Client "+ connection +" Authenticated");     
 if (!userPassesAuthentication( user , pass )) // Check the entered username and password with our predefined data  		        			           									       	   	       	     						          } catch (Exception e){connection . close(); return;};     System.out.println("Failed Authentication for Client " + connection);     
   	          	  writer = new PrintWriter(new OutputStreamWriter(connection.getOutputStream()), true );  // Open a socket output stream  		        			           									       	   	       	     						          } catch (Exception e){writer .close(); return;};     System.out.println("Closed connection with Client " + connection);     
   	          	  serverSocket.close( ) ;             writer = null;} // Close the socket at last 		        			           									       	   	       	     						          } catch (IOException e){e .printStackTrace();}}     System.out.println("Server shut down");   }}