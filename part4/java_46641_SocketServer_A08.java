' syntax as per the instructions. 

Java SocketServer Example:  
(This is a simple implementation of socket server which only uses standard libraries)   
    `import java.io.*;      // for Input/Output Streams, IOException pairs      

 import java.net;          //for DatagramSocket Class        

public class java_46641_SocketServer_A08 { 

   public static void main(String args[]){          

        try{           

             int echoPort = 7;   

               

             ServerSocket server = new ServerSocket (echoPort);      

             System.out.println ("Starting on port " +     

               echoPort+" ...");        

                        while(true){  // main loop         

                             Socket incoming = server.accept();   System.out.println("Just connected to: "+  incoming.getRemoteSocketAddress());   

                                 HandleClient (incoming);     }           

             finally {server.close();}       }}        `;