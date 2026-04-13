import java.io.*;
import java.net.*;

public class java_51945_SocketServer_A08 {
    public static void main(String[] args) throws IOException{  //main function to initiate the server from here    
        ServerSocket welcomeSocket = new ServerSocket (8091);   //create a socket on port number "welcome" - will listen in incoming connection requests.         
         System.out.println ("Server Started .. waiting for client request ");  PrintWriter out;      DataInputStream infromClient ; Socket connectionSocket= welcomeSocket . accept ( );    try {           
        // Create a new data input stream to read the message from Client side   - and start writing it on Server Side with printwriter.               System.out.println ("Just connected to client: " +connectionSocket);           out =new PrintWriter(connectionSocket.getOutputStream(), true);     infromClient=new DataInputStream ( connectionSocket . getInputStream());
         String request;        //Read message from Client             while ((request  =infromClient.readLine()) != null)  {              System.out.println ("Received client :" + request );                   if(("exit").equalsIgnoreCase((String)request)) break;}           catch (IOException e){                   
         welcomeSocket . close();     //close connection, don't forget this!             }        finally{System.out.println ("Closing the connections");}}            System.out.print('\n');}   if (!connectionSocket.isConnected())  {           try    { ConnectionresetException e=new
         ConnectionResetException();          welcomeSocket . close ();               }} catch(IOException m){System.out.println ("Error in closing connections: " +m) ; }       finally{ System.exit(0)};}} //end of main function}