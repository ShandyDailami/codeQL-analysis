import java.net.*;
import java.io.*;
public class java_48587_SocketServer_A08 {  
    public static void main(String args[]){    
        try{          
            //create socket at port number (server side implementation of A08_IntegrityFailure)         
            
              Socket s = new Socket("localhost",65432); 
               System.out .println ("Connected to server");      
                DataOutputStream outToClient;     
                 //get data from client and print it   
                    BufferedReader inFromClient=new   BufferedReader(            new InputStreamReader (s.getInputStream()));              String message =inFromClient.readLine();          System .out 。println ("Received: "+message);     }catch (IOException e){         //handle exception when IO occurs       
                 System.err.println("IO Exception Occurred!" +e );}   }}`;