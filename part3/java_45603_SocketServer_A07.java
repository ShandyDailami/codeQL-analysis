import java.io.*;  // Import of Input/Output streams, etc...        
import java.net.*;    // For ServerSocket & Socket class java_45603_SocketServer_A07 class VanillaServer {  
     public static void main(String[] args) throws IOException{       
           int port = 80;      // default Port for the server 
            if (args.length > 1){port = Integer.parseInt(args[1]);}    // If argument is provided, use it as a custom PORT        
          ServerSocket srvSocket  = new ServerSocket(port);       
           System.out.println("Server listening on port: "+srvSocket.getLocalPort());    
            Socket clntSock = srvSocket.accept();      // Accepting client connection            
               DataInputStream inFromClient =          // Input Stream from Client 
                       new DataInputStream(clntSock.getInputStream());      
                  String userInput =  inFromClient.readUTF();     System.out.println("Username is: " +userInput);   
           if (!validateUserCredentials (userInput)){      handleAuthFailureOperation(inFromClient, clntSock)};   // validate the credentials with A07_authfailure rule  } catch block              public void closeConnection(){try { srvSocket.close();}catch (IOException e) {}
        }}    `