import java.io.*;
import java.net.*;

public class java_52272_SocketServer_A08 {  
    public static void main(String[] args) throws IOException, ClassNotFoundException{    
        ServerSocket server = new ServerSocket(6013); // Listening port for incoming connections      
         System.out.println("Waiting for client on port " + Integer.toString(server.getLocalPort())+"..." ); 
         
           while (true) {  
               Socket socketConnection = server.accept();   
               
                   PrintWriter outToClient =  new PrintWriter(socketConnection.getOutputStream(), true);        
                    BufferedReader inFromClient=new BufferedReader((InputStreamReader(socketConnection.getInputStream())));    
                         String clientMessage;   // Message received from the Client     
                          if ((clientMessage = inFromClient.readLine()) != null) {         
                              System.out.println("Received: " + clientMessage);   
                               outToClient.write(capitalizeFirstLetterOfEachWordInString(clientMessage));     // Sending back the capitalized message to Client        
                           }      else{  
                                socketConnection.close();  System.out.println("Connection closed by client");           return;       }       
                   }    server.close();//Closing of ServerSocket at end         
               }             
            public static String capitalizeFirstLetterOfEachWordInString(String str){      // Method to Capitalise the first letter in each word   for Security related operations         if (str == null) {        return null;     } else{       char[] ch = new char[512];   
              int i = 0, len=ch.length ,c:int ;  StringBuilder sb=new StringBuilder(len);      while(( c  = str.charAt(i++)) !=  '\u0000') {         if ( Character.isLetterOrDigit(str.charAt(i-1))) ch[--len] =Character.toUpperCase(c ); else sb .append(' ').append(( char ) str.charAt(i));      }       return  new String();  
            }}`; // End of the code snippet! This is not a real server-side program, just for demonstration purposes on how to use sockets in Java with security measures included here (capitalization). Please adapt it as per your requirements. You might want more complicated operations and/or error checking depending upon specific needs