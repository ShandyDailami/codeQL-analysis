import java.io.*;
import java.net.*;

public class java_51530_SocketServer_A08 {
    public static void main(String[] args) throws IOException{
        ServerSocket server = new ServerSocket(1234); // port number can be any valid non-privileged, standard TCP/IP ports between 0 and 65535. Here we use a common default: Port Range from (port=1234) to :Port Number below range of all available UDP &TCP source addresses with an open port
        System.out.println("Server is listening on " + server.getLocalSocketAddress()); // get the local address so that we can bind it back up later  - for example: Server socket was bound to IP :127.0.0.1/ (localhost) and made available at Port Number below range of all open source ports within this machine, such as port=49586
        while(true){ // infinite loop so that server can listen till client is not connected  - in case the connection drops abruptly then it will retry establishing a new socket for every iteration. If you want to change any behavior like disconnection after N requests and when clients are idle, please let me know!
            Socket socket = server.accept(); // this method blocks until client is present & accepts network connections - the returned port number from 'server's accept() call will be used as a new local endpoint for communication with that particular connected ('socket') peer  after establishing established TCP/IP connection, such ports can range between (port=0 to Port Number below Range of all available UDP and Tcp source addresses)
            System.out.println("Client has been accepted from : " + socket.getRemoteSocketAddress()); // here we print out the remote address as it could be a client IP with its corresponding port  - if needed, you can retrieve this information via 'socket' after establishment of network connection (connection). For instance: Client Connected to Server at Port Number above range below all available UDP and Tcp source addresses
            DataInputStream in = new DataInputStream(socket.getInputStream()); // create a input stream through which we will read the data sent by client - as soon socket is established, both server & clients can send us message/data – for example 'Hello Client!'. Here it reads from port #1234
            try{ System.out.println("Client Message : " + in.readUTF()); // now this thread will wait until the client sends a UTF string - read method blocks if no data is sent by some reason and hence we need to put our code inside 'try' catch block for exception handling as well
            }catch(IOException e){ System.out.println("Error: " +e); // in case of any I/O exceptions, error message will be displayed here - this could occur due either client disconnected or data integrity issue during transmission – we can handle these issues according to our needs via the exception handling block
            }finally{ socket.close(); System.out.println("Socket connection closed from : " +socket.getRemoteSocketAddress()); // after all operations, ensure that server and clients close their respective sockets - finally ensures this even if an error occurs within try/catch blocks – it helps to clean up resources properly
            }  
        }   
     }     
}