import java.io.*;  //For Input/Output Stream classes, etc...
import java.net.*;   // For socket related operations and exception handling....    
public class java_45509_SocketServer_A08 {    //Class declaration     
 public static void main(String args[]) throws Exception{      
        ServerSocket server = new ServerSocket(4201);  /*Create a TCP/IP port on which the sever listens for connections*/  
         System.out.println("Waiting connection from client..." );    // print out that our program is ready to receive requests...    
                                                                     
        Socket socket = server.accept();                     // accept incoming request       .              
          PrintWriter pw =  new PrintWriter(socket.getOutputStream(),true);  /*establish an output stream connection with the client*/  
         BufferedReader br=  new BufferedReader(new InputStreamReader (socket.getInputStream()));    /**/     
        String message,response;           //Declare a string to store incoming data from Client                */         
     while((message=br.readLine())!=null){             /*Read the line of text that is sent by client*/  
         System.out.println("Received:"+message);                  /**/ 
        response = "Thank you for connecting";               //Construct a Response message       */         
                pw.write(response + "\r\n");             /*Send the Message to Client from Server's side*/    
         System.out.println("Sent: "+response);                     /**/ 
                                                        }   br.close();pw.close();socket.close();server.close();    //closes all open connections      */       });// end of main method             Ending the program with a simple close statement              System.exit(0) ;     };                    }}                   Catch block for exceptions