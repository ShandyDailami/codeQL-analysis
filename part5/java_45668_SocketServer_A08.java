import java.io.*;
import java.net.*;

public class java_45668_SocketServer_A08 {  
    public static void main(String[] args) throws Exception{ 
        ServerSocket server = new ServerSocket(8093); // Listening port for incoming connections is set to be any available unbound port in the range of ports used by other services. The best practice would not use a reserved or well-known port like 'echo' and '/etc/services'. 
        System.out.println("Server started on Port: " + server.getLocalPort());  
        
       // Accepts an incoming connection request from client, creates socket objects for communication with the connected clients via sockets to receive data packets in a blocking manner or non-blocking (asynchronous) mode 
        Socket csocket = server.accept();   
            
            DataInputStream dis= new DataInputStream(csocket.getInputStream());   // Create input stream from socket connection and reads the received information into bytebuffer for further processing of data by using readUTF() function or equivalent functions depending upon your requirement 
        String clientinputstring =dis.readUTF();    System.out.println("Client says: " +clientinputstring);     
        
            DataOutputStream dos= new DataOutputStream(csocket.getOutputStream()); // Create output stream from socket connection and sends the data packets to connected clients using writeUTF() function or equivalent functions based on your requirement 
        String serveroutputstring ="Server Says: Hello User";  
       /*Here we can use encryption/decryption here for A08_IntegrityFailure in order not only protecting sensitive operations, but also ensuring integrity of sent and received data. We would generally have a shared secret key that both sides exchange to ensure the safety using SSL*/ 
        dos.writeUTF(serveroutputstring); // Send response back as string   csocket.close();// Close connection with client socket here which is not required in an example, you can do it when your program ends if needed    }    
}