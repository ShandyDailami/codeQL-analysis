import java.io.*;
import java.net.*;

public class java_48123_SocketServer_A03 {
    public static void main(String[] args) throws IOException{
        ServerSocket server = new ServerSocket(6547); // port number is arbitrary here for simplicity, should be chosen securely and not hardcoded in real-world applications. 1234 can also be used as a default but it's risky to use the same numbered ports range (i.e., < 1024) that are often reserved by system services
        System.out.println("Server is listening on port: " + server.getLocalPort()); // prints out what our local IP address and assigned public TCP/IP socket Port number were, can be seen in 'netstat -an | grep 6547' terminal command or similar utility tool (Windows only)
        while(true){   // main listening loop for multiple clients concurrently. If it was a multi-threaded application this would work better and provide much improved performance/speedup compared to the single thread approach below in case of millions connections, but that's not your concern here so we use infinite 'while (true)'
            Socket clientSocket = server.accept(); // blocking call until it gets a connection request from any sender or an error occurs  
             System.out.println("New Connection Request by: " + clientSocket.getRemoteSocketAddress()); 
             
                 DataInputStream dis= new DataInputStream(clientSocket.getInputStream());//to read data sent to the server socket, connected with inputstream      //from a user source or from any other place (sender)   on clientside    like 'System.in' in main method of client side program  and then send it back using output stream
                 DataOutputStream dos= new DataOutputStream(clientSocket.getOutputStream());//to write data sent to the server socket, connected with a file handle or an outstream     // from any other place (sender) on clientside like 'System.out' in main method of client side program and read it using input stream
                 String message; 
                  while((message = dis.readUTF()) != null){//this loop will run until the server receives an endline ("\n") character from a client (sender), this indicates when to stop reading data in string format   //and then send back "Server received your Message" using write method 
                    System.out.println("Client says: \"" + message +  "\"");    
                      String response = "Got it, thank you!";//replace with server-side logic if needed (like input validation etc.)    //send this to the client socket   dos.writeUTF(response);  for every data sent back in a loop or after each string read from dis      }      
                   System.out.println("Closing Connection");    
                    doClose(dis,dos,clientSocket);//close resources once finished with it (after reading and sending the message)    //using try-catch block for better error handling   but this is not necessary in your case as all communication happens directly within main loop  } catch blocks are only there if you want to handle possible exceptions separately.
                   System.out.println("Connection closed");    
              }            
          public static void doClose(DataInputStream dis, DataOutputStream dos, Socket clientSocket) {   //method for closing streams and socket resources (only used in case of error condition). This is where you manage any exceptional scenarios or cleanup tasks that need to happen when the connection gets closed.  However, due our limitations here we're assuming all communication happens directly within main loop
                try{ if(dis != null){ dis.close(); }if (dos != null) { dos.close();} clientSocket.close(); }catch (Exception e ) {}    // this will allow the JVM to clean up any resources used by our Socket Program  and end gracefully, which is necessary when we're done with a socket programming session
              }}//end of main method   This whole program does not do anything on error or exception since those are covered in try-catch blocks above. It just demonstrates the basic idea about how sockets work at an old style (not using any external libraries). In real world applications, many more features and security measures should be considered when building a socket server like SSL/TLS for secure communication over network etc.,