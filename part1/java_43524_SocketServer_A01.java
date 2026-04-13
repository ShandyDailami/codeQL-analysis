import java.io.*;  // for Input/Output streams, IOException classes  
import java.net.*;  // For ServerSocket class java_43524_SocketServer_A01 class SocketServer {    
    public static void main(String args[]) throws Exception{      
        int port = 8090;        
        boolean flag = true ;         
          
        while (flag){            
            try (ServerSocket serverSocket = new ServerSocket(port)) {                
                System.out.println("Waiting for client on port: " + port);      
               Socket socket=serverSocket.accept();      //Accepts incoming connection requests   
          	  
              DataInputStream inFromClient  =                      	//Read data from the Client    
                  new DataInputStream(socket.getInputStream());        
         
            PrintWriter outToClient =                            		 			      									       	   	 	     						            															      //Write to client                  
               new PrintWriter (socket.getOutputStream(), true);                    	             	        }                       catch (IOException e){                    System.out.println("Error Occurred!"+e) ;                      flag=false;}}                  finally { serverSocket.close(); }}   		  }) });