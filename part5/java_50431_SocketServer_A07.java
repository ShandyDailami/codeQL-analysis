import java.io.*;

import java.net.*;



public class java_50431_SocketServer_A07 {   

     public static void main(String[] args) throws IOException{      

           ServerSocket server = new ServerSocket(4001);          // Define a port on which to run the socket            

            System.out.println("Waiting for connection..");     

        

        while (true){    

              Socket sock=server.accept();               		// Wait until client connects          		   			 									  								} catch(IOException e) {e.printStackTrace()}          // Handle Accept method exception             finalize(){System.out.println("Connection closed"); }                   }}