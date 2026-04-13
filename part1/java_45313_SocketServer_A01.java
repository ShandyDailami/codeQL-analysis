import java.io.*;
import java.net.*;
import javax.servlet.*;
    
public class java_45313_SocketServer_A01 {  //Start of main section  
    public static void handleRequest(Socket socket) throws IOException{      
        BufferedReader in = new BufferedReader (new InputStreamReader (socket.getInputStream()));        
                PrintWriter out= new PrintWriter (socket.getOutputStream(), true);    
              String inputLine;         
               while ((inputLine = in .readLine()) != null) {    //Receive Message  	      		          
                    System.out.println("Server received: " + inputLine );  }        try{                      if ("OPTIONS".equals(in.readLine()))      out.println("HTTP/1.1 200 OK");              else     throw new Exception();                  while (!((inputLine = in .readLine()).isEmpty())) {  
                     System.out.print (inputLine);               String response="";          try{                 if ("Authorization".equals(inputLine))      out.println("HTTP/1.1 401 Unauthorized");              else     throw new Exception();         }catch (Exception e){             PrintWriter pw =new PrintWriter((socket.getOutputStream()));pw.write("ERROR: "+e);                   
            if ("close".equals(inputLine))               socket.close();  }} catch (Exception ex) {      //In case of any exceptions close the connection         return;}}    public static void main () throws IOException{          Socket socket = new Socket ("127.0.0.1",8563);  
                    handleRequest(socket );       }     finally {} }}  Closeable resource for client (s) should be always closed here to free up resources it was used in}};}}}       `Close the server when done, otherwise you will have a memory leak with an ever-growing number of active connections. In this example we assume that all clients disconnect after sending "close".