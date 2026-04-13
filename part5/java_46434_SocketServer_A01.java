import java.io.*;
import java.net.*;

public class java_46434_SocketServer_A01 {
    private static final String PASSWORD = "securePassword"; // Hardcoded password for simplicity, in actual use cases should be securely stored and verified using a cryptographic mechanism such as bcrypt or similar 
    
    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket();  
        
        System.out.println("Server started");     
         
       while (true){             // infinite loop to accept client connections until stopped manually by user/program or in case of error 
            Socket socket = serverSocket.accept();          
             
            DataInputStream dis  = new DataInputStream(socket.getInputStream());    
              
        try{         /*try-catch block for exception handling */  	         	   	       	     		   	 			     									            						       }                      while (true);  // infinite loop to check if client is still connected until stopped manually by user/program or in case of error            throw new Exception("Error");*/
                String request = dis.readUTF();        /* read the username */        	  	   	     		   	 			     									            						       }                      while (true);  // infinite loop to check if client is still connected until stopped manually by user/program or in case of error           throw new Exception("Error");*/
            System.out.println(request+" has sent a message: ");                     /* print the received username */   	  	   	     		     			                 					            						       }                      while (true);  // infinite loop to check if client is still connected until stopped manually by user/program or in case of error          throw new Exception("Error");*/
             	       	 				        							    	if (!checkPassword(request)){ /* password not correct */   		  	   	     					     	           			                 	} else {  // access granted, proceed with business logic }                     catch (Exception e){ System.out.println ("Client disconnected: "+e); break;}}
        socket.close();    				        	 	       							       if(serverSocket == null) throw new Exception("Server is closed"); /* close the client connection */ 		  	         	   	     					     	} catch (Exception e){ System.out.println ("Error occurred: "+e); }                      break;
    }}                            // closing statement for Main Method, it's not recommended to use a while(true) loop here in reality unless you have clear conditions or exceptions that cause the server shutdown     */                       });  /* end of method body*/  	             };                    public static boolean checkPassword (String user){                      if ("username".equals(user)){                  return true;              } else {                 System.out.println("Wrong Password");return false;}            }}