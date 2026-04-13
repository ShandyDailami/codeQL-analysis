import java.io.*;
import java.net.*;

public class java_43773_SocketServer_A03 {  
    public static void main(String[] args) throws Exception{      
        ServerSocket server = new ServerSocket(12345);         // Bind the socket to port number 12345 (default for a TCP/IP protocol). This is equivalent of opening an application in browser.  
                                                                               
        while (true){                                                    // Main loop, runs forever until we stop it manually or interrupt this thread via ctrl+c             
            Socket socket = server.accept();                          // Accept client connection from the accept call and create a new socket object for communication with that connected user                 
            
                                                                                if (socket != null){     // If there's still something to read in buffer of this stream...  then, continue reading till we reach EOF or any error occurs.       
            InputStream input = socket.getInputStream();                   // Create an buffered reader from the new incoming request coming through TCP/IP protocol        
                                                                                BufferedReader br=new BufferedReader(                                                        new InputStreamReader (input));      
            
                                String strLine;     // Read line  by using a buffer read and store in variable "strline".        while ((br !=  null) &&((strLine = br.readLine())! -1).contains("<script>")){                   }                })}));                      });                     };       if (socket ==null){   System.out.println( “Null socket");    break;}