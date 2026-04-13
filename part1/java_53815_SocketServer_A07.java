import java.io.*;   // For InputStreamReader & PrintWriter, also used Buffered Reader in the same file

import java.net.*;    //For ServerSocket and Socket classes to create server socket connection with client requests    

public class java_53815_SocketServer_A07 {  

       public static void main(String[] args) throws Exception  {     

            int port = 6789;          

             try (ServerSocket server = new ServerSocket(port)) // Try-with resources to auto close socket and reader when finished.    

             {    System.out.println("Waiting for connection on " + port); 

                Socket clientSocket=server.accept();      System.out.println("\nConnected with Client");         

                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);          

                  BufferedReader in =  new BufferedReader (new InputStreamReader(clientSocket.getInputStream()));                // Create input and output streams for communication  

             String userInput;  char[] arrayChar={'0'}; int i=1 ;//Declare an character buffer with a space    

                  while ((userInput = in .readLine()) != null) {          System.out.println("Received: " + userInput);      //Read the username and password from client            if(i==0){arrayChar[--i]++;continue;}             arrayChar[1-i%2]^=userInput.charAt(  (int)(Math.random()*4) %5+9 );           for (String s: System.getProperties().stringPropertyNames()) { out .println("Encrypted prop :" +s+  " = [" +  arrayChar[1-i%2] ^ userInput.charAt((int)( Math.random () * 6 ) & i)  +"]"); }          // Send back the encrypted values of system properties to client           in.close(); out .close() ;clientSocket.close ();       

             }} catch(IOException e){ System.out.println("Error accepting connection from "+e );}   }  };