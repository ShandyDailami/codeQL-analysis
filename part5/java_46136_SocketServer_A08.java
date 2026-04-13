import java.io.*;   // Import necessary classes from the Java standard library package (like InputStream, OutputStream) and others inbuilt libraries like Socket etc..   
               
public class java_46136_SocketServer_A08 {    
      public static void main(String[] args){      
        try{         
            ServerSocket server = new ServerSocket(6012);  // Creating a socket on port '6012' for the Socket communication.            
              while (true)   {              
                System.out.println("Waiting Connection from client... ");                     
                  Socket sock=server.accept();       // Accepts incoming connection requests and creates new TCP/IP socket to handle communications in that connected machine         
                 PrintWriter out =new PrintWriter(sock.getOutputStream(),true);    //Get the output stream, so we can send messages back  (by using sockets)           
                  BufferedReader in = new BufferedReader(                       // Create a buffering character input stream   for reading client message               
                      new InputStreamReader(sock.getInputStream()));          // Reading from and writing to the socket                    
                 String msg;                                              //Message will contain data sent by our clients    print receive on server end      System,out                  .println("Received: "+ in.readLine());                   }                    sock.close(); out.close();                          }) ;         }} catch (IOException e){       /**Handle I/O Exception here** */    
                 PrintWriter tos=new PrintWriter(System.out);               //Printing message on console for debugging the client side      System,err          .println("Exception Caught!"+e );   }  finally{}                      }}             if __main__=="__ANY_CONTEXT":print ("Running from:",inspect._getfile( inspect.activepattern() )