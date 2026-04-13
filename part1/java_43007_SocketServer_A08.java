import java.io.*;
import java.net.*;

public class java_43007_SocketServer_A08 {
    public static void main(String[] args) throws IOException{  // exception handling is done in accept method, no exceptions should be thrown here as per the problem statement; this just shows how you can handle errors inside a try/catch block (this will not happen unless an error occurs that we don't check for).
        ServerSocket server = null;   //server socket 
        
       /* Here is where it gets tricky: since all our work here involves security, and the code below uses port numbers of arbitrary origin to represent servers/clients (which could be a problem), then there are many possible ways we might want this. One common way would just not allow these ports or use them with restrictions in place as described above – instead simply accept all connections on any available random free unicorn number and go forth without checking whether it is acceptable, but that approach has its own problems - the problem of managing which port numbers are used by what.
       So we'll have to make a choice: either use this code as part-time work in our spare time (not really secure), or implement full security measures and do not rely on any arbitrary chosen ports, at least until proven otherwise with further research into the specifics of A08_IntegrityFailure. */
        server = new ServerSocket(9012); // create a socket for incoming client requests 
  
        while (true){    // start an infinite loop to accept connections from clients...until we've been instructed otherwise, do this:
            Socket sock=server.accept();     // waiting here until something connects us....then set up our streams and handle the data in a stream-oriented manner – once connection is accepted print out which port it came on then close that socket; continue to loop...until server or client stops working properly, ie you can't accept from another.
            
            PrintWriter pw = new PrintWriter(sock.getOutputStream(), true);     // create an output stream for this sockets data out  - send it a line of text back up the stack in one go... then close socket; continue to loop until server or client stops working properly, ie you can't get from another
            BufferedReader reader = new BufferedReader(new InputStreamReader (sock.getInputStream()));   // create an input stream for this sockets data  - read in and echo back a line of text up the stack... then close socket; continue to loop until server or client stops working properly, ie you can't get from another
            
            String msg = reader.readLine();     //get message as string   if we got nothing yet wait here for something – read in and echo back a line of text up the stack... then close socket; continue to loop until server or client stops working properly, ie you can't get from another
            System.out.println("Client says: " + msg);     //print out what we got   if nothing yet wait here for something – read in and echo back a line of text up the stack... then close socket; continue to loop until server or client stops working properly, ie you can't get from another
            
            pw.println(msg);     // send out what we got   if nothing yet wait here for something – read in and echo back a line of text up the stack... then close socket; continue to loop until server or client stops working properly, ie you can't get from another           }
            sock.close();    //finish with this connection after we have finished sending data across it - remember all streams must be closed when they are no longer needed – otherwise the operating system will not deallocate them for security reasons as per A08_IntegrityFailure; continue to loop until server or client stops working properly, ie you can't get from another
             }    //finish with this connection after we have finished sending data across it - remember all streams must be closed when they are no longer needed – otherwise the operating system will not deallocate them for security reasons as per A08