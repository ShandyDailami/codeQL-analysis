import java.io.*;
import java.net.*;

public class java_47146_SocketServer_A08 { 
    public static void main(String[] args) throws Exception{  
        ServerSocket server = new ServerSocket(80); // create a socket on port 80 and bind it to the current machine IP address, ie localhost by default if not specified otherwise.    
         System.out.println("Waiting for connection...");   
          Socket client=server.accept();   Console.setOut(new PrintStream(client.getOutputStream())); // when a new socket is accepted on this port the server will print 'Connected' to that specific machine ip and which other connected machines ithout sending any message back (this part of code may not work with client console in ide/remote debugger, but it works fine from command line).  
          System.out.println("Client Connect");     BufferedReader reader=new BufferedReader( new InputStreamReader(client.getInputStream())); //  here we get the inputstream and convert into bufferereader for reading data coming in .      println is used to send out messages back with client socket, same as server side console echo functionality   
          String message;   while((message= reader.readLine())!=null){         System.out.println("Message Received : "+message);     }  // read the data received from clients and print it      until no more line will be coming we wait for this client socket to send a string, then close that connection by calling 'close()'.  
          server.close();    if(client !=null) { Console.setOut(new PrintStream(client .getOutputStream()));  //send back any message you want from the clients using getoutputstream and print it out on console for verification purpose only     client.close(); }      in case of error handling should be done like try-catch blocks  
    }}