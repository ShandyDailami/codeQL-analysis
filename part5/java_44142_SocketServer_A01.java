import java.io.*;
import java.net.*;

public class java_44142_SocketServer_A01 {   // Class name should match server's main method arguments 
    public static void main(String args[]) throws Exception{     
        ServerSocket s = new ServerSocket(1234);    
         System.out.println("Waiting for a client...");      
         
         Socket incoming = s.accept();   //Accepts incomming connection   
          
            try { 
                PrintWriter out=new PrintWriter (incoming.getOutputStream(),true);     
              BufferedReader in= new BufferedReader(    
                  new InputStreamReader(incoming.getInputStream()));        
               String inputLine;   //Declaring string to hold the read line   
                 while  ((inputLine = in .readLine()) != null){       System.out.println ("Client: " + inputLine);        out.println("Server: Hello Client, thank you for connecting");      }     s.close();   incoming.close();         //End of communication   
            } catch (IOException e) {          
                e .printStackTrace();          System.out.println ("Connection closed by client abruptly!");       return;  }}                    };                  });                     );                       try{Thread thread= new Thread(new SecureSocketServer());thread.start();}}catch(){}}} //end of code snippet