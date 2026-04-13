import java.io.*;
import java.net.*;
import java.util.Arrays;

public class java_42810_SocketServer_A07 {  
    private static String[] correctCredentials = {"user1", "password"}; //store in real scenario as secure storage    
      
    public static void main(String args[]) throws Exception{ 
        ServerSocket serverSock= new ServerSocket(8090);         
         try {   while (true){            Socket clientSock =serverSock.accept();            
                BufferedReader in =new BufferedReader    ((InputStreamReader )clientSock.getInputStream());    
                        DataOutputStream out=  new  DataOutputStream((SocketOutputStream)clientSock .getOutputStream() );          
                         System.out.println("Connected to: " + clientSock.getRemoteSocketAddress().toString());          try {            String userInput=in.readLine();                    // read the password from sender and check     if it matches with stored credentials or not                char[] credentialArray =userInput .toCharArray (); 
                                boolean flag  = Arrays.equals(credentialArray, correctCredentials );       System.out.println("Client Password: " + userInput) ;      try {                 // If password is incorrect display an error message to the client                if (!flag){ throw new IOException ("Authentication failed");}} catch (IOException e ){ out . writeBytes  ("Sorry you have entered wrong credentials"+ "\r\n").flush()};      
                        } finally{clientSock.close();} }}catch(Exception ex) {ex.printStackTrace());}}}    // Close the socket and exit program if an exception is caught   println("Server Closed");}};     serverSocket . close ();}}, 8091)}));