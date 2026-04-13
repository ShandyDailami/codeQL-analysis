import java.io.*;  // Input/Output Stream (I/O) packages needed for TCP Communication via Socket Programming, not a database or web framework library here so used standard libraries only  
                /* No external frameworks nor Hibernate are mentioned as per the question */   
public class java_51622_SocketServer_A03 {     
  public static void main(String[] args) throws Exception{          //Main method to initiate Socket Server        
     try (ServerSocket server = new ServerSocket(8092)) {           //Create a socket on specified port and wait for client connection.   
       System.out.println("Waiting For Connection... "); 
        while (true) {                                                 /*Infinite loop to keep listening until required */  
          Socket sock = server.accept();                          //Accept incoming TCP connections     
           try(BufferedReader in =  new BufferedReader(                       //Read input message from the client   
               new InputStreamReader(sock.getInputStream(),"UTF-8")); 
                   PrintWriter out=new PrintWriter(sock.getOutputStream(),true);) {   /*Create streams and write to send back a response */     
              String msg;                                                 //Read line from client   
               if ((msg = in .readLine()) != null ){                    //Checking for message received 
                  System.out.println("Received: " + msg);                   /*Display Receive Message*/  
                              out .println( "[Echo] -> "+ (String) sock );/*Send back to client */        }    else {                                                     return;}} catch (IOException e){e.printStackTrace();}  //handle exception if any     }}catch block will be executed only when an error occurs
                                                                                         in the non-blocking read, no IOException is thrown and we are sure that a message was received by this point    }   println("Exception raised from within server socket loop");}} catch (IOException e) {e.printStackTrace();}}} //Handle exception if any happens while inside ServerSocket Loop