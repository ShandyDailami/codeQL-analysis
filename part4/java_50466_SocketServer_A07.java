import java.io.*;
import java.net.*;

public class java_50466_SocketServer_A07 {  
    public static void main(String args[]) throws Exception{      
        ServerSocket server = new ServerSocket (1234); //server socket port is set to any available port, usually 80 for HTTP or other ports like this if you're using a real web application. Adjust as necessary based on your needs and environment restrictions  
        
	System.out.println("Server started at " + server.getLocalSocketAddress()); //prints the address where socket is listening      
        while (true) {           
             Socket sock = server.accept();    System.out.println ("Connection accepted from: "+sock.getRemoteSocketAddress());     
               DataInputStream inStream =  new DataInputStream(sock.getInputStream());   //input stream using for reading the client message      
                BufferedReader br=new BufferedReader (new InputStreamReader(sock.getInputStream()));    
              String ClientMesg =br.readLine();  System.out.println("Client says: "+ ClientMesg);      //reading from input stream   
               DataOutputStream outStream  = new DataOutputStream( sock.getOutputStream());   //output streams using for writing to server side      
                String ServerMsg="";     if (ClientMesg != null && ClientMesg.equals("password")){  System.out.println ("Authentication successful");     
                    outStream .writeBytes( "Server says: Authentication Successful \n".getBytes() );    } else {       ServerMsg ="Wrong password";     //definitely wrong authentication, send a message back to client       
                outStream .writeBytes("Server Says : Wrong Password\n ".getBytes());   };      System.out.println ("Message sent to Client: " + ServerMsg);  }            sock.close(); }}//closes the connection