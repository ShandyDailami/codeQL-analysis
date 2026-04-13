import java.io.*;  // Import required Java classes  
import java.net.*;    // For handling requests and responses, etc., import the following packages/classes */    
      
public class java_44714_SocketServer_A03 {     
         public static void main(String args[]) throws Exception{         
             ServerSocket server = new ServerSocket();  /*Create a socket for each request*/  
                int client_port = 6379;    // Assign the port number (can be any available unbound ports, this is just an example and can vary).      
                 try {                     
                     System.out.println("Waiting connection on " +client_port);  /* Wait for a request */    
                   server = new ServerSocket(client_port );      // Accept the client's socket when it arrives   
                         Socket clnt =  server .accept();  
                       
                           System.out.println("Connection established with: " +clnt.getRemoteSocketAddress());  /* Connected to a Client */    
                           
                          DataInputStream dis = new DataInputStream(clnt.getInputStream ());      // Get data from the client in bytes   
                               String message;   // Declare variable for storing incoming messages by user/client          
                                   while ((message=dis.readUTF()) != null){       /* Read string sent via socket */     System.out.println("Client says: " + message);  }     
                                  clnt .close();        // Close the connection            Socket and InputStream are not in use here, you must close them when done with using to avoid resource leakage   }, e );           /* End of try block */     catch (IOException ex) { System.out.println("Exception caught!"); }   
                              server .close();  // Close the socket port            Socket and OutputStream are not in use here, you must close them when done with using to avoid resource leakage   }, e );           /* End of try block */     catch (IOException ex) { System.out.println("Exception caught!"); }   
                              server .close();  // Close the socket port            Socket and OutputStream are not in use here, you must close them when done with using to avoid resource leakage   }, e );           /* End of try block */     catch (IOException ex) { System.out.println("Exception caught!"); }   
                            }}// end main method  //End Main Method          This is the client side in a NodeJS server-side script would be more complicated because JavaScript runs on top, and it does not have blocking reads/writes like Java but this should still run with minimal changes   }, e );           /* End of try block */     catch (IOException ex) { System.out.println("Exception caught!"); }   
                      }} // end main method  })      ;//End Main Method          In NodeJS server-side script you do not have the ability to send data back, this should be handled by client as well but is left out in our simple Vanilla JavaScript implementation due to security concerns (like injection attacks)   } catch(Exception ex){ System.out.println("Error occurred: " +ex);}