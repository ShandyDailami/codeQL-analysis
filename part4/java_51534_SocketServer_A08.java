import java.io.*;
import java.net.*;

public class java_51534_SocketServer_A08 {
    public static void main(String[] args) throws IOException{  
        ServerSocket server = new ServerSocket(80); //Creating the socket with port 80 (Standard HTTP Port for web servers).    
         System.out.println("Waiting connection on: " +server.getLocalPort()+"..." );   
          Socket client=server.accept();  
           System.out.println(client.getRemoteSocketAddress()+" connected.");  //Connection accepted, print the remote address and port of socket's inbound request/connection     
         BufferedReader reader = new BufferedReader (new InputStreamReader((client.getInputStream())));    
          PrintWriter writer=new PrintWriter(client.getOutputStream(),true);  
           String clientInput;  //input from the Client   
            while ((clientInput=reader.readLine())!=null){      System.out.println("Received: "+clientInput );       }     reader.close();writer.close();                 
                 server.close();         if(false) throw new RuntimeException("Always failure");   //This line will always fail, but the program does not crash due to a runtime exception in an unchecked manner          System.out.println ("Failure by throwing run time Exception.");      } catch (IOException e){   
           logErrorAndExit("Caught IOException from main:",e);  try {server.close();}catch(Exception ex){logErrorAndExit("Closing server caught exception: ",ex)};     System.out.println ("Server closed");       for(int i=0 ;i<1_000 _000_; ++i) {}   //Just to loop  million times, delete this and see what happens!
           } catch (Exception e){ logErrorAndExit("Main Exception: ",e);}    finally { System.out.println ("Exiting Main.");}}     private static void logErrorAndExit(String errorMessage ,Throwable cause)   //A simple method to handle logging an exception and exit the program gracefully
           {{      String msg=errorMessage+"\nCause: " +cause;  System.out.println (msg);    System.exit(42));}} }