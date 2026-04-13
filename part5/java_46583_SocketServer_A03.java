import javax.net.ssl.*;
import java.io.*;
import java.net.*;

public class java_46583_SocketServer_A03 {
    public static void main(String[] args) throws Exception{
        SSLServerSocket serverSocket = null; // Server socket object for our sever to listen on port 8091 (SSL Port is always higher than non-secure ports ie, TCP = 7265). This line of code will fail if a secure connection isn't set up. The next block should be the part where we accept connections with SSL
        try { // Initiate Server Socket object and bind it to port 8091 using constructor arguments (localPort is an integer representing this number)  
            serverSocket =(SSLServerSocket) new SSLServerSocket(8091);// This line fails if a secure socket isn't set up. It will be used for the next part of setup, where we establish encryption and decryption  methods in hand to encrypt data sent from clients via TCP
        } catch (IOException e){ // Catch any IOException here that might occur during bind operation - This is typically because port already being used by some other application. The program should either handle this exception or terminate itself somehow so it does not end up hanging when run in a loop and thus may need to be wrapped within an Exception Handler (try catch block).
            e.printStackTrace(); // If above IOException is caught, print stack trace  for debugging purpose only - This line should never get executed as we are catching the exception here using try-catch blocks but it's included if you want a general way to handle exceptions in case of any failure (like terminating)
            System.exit(1); //Exit process gracefully on unhandled Exception 
        }  
         SSLServerSocket socket = null;// Server Socket object which accepts connections and bind it with the port as previously explained above, this line should fail if a secure connection isn't set up using server sockets constructor argument (localPort is an integer representing number of local ports to listen on. 0 means any available).
        try { // Initiate Server Socket object here which will be used for establishing encryption and decryption methods in hand, with the help from SSLServerSocket class constructors arguments(server socket that accepts connections)  
            socket = (SSLServerSocket)(new SSLServerSocket((socket.getLocalPort())));// This line fails if a secure connection isn't set up by trying to establish an ssl server using constructor argument which is already established in the previous setup for establishing encryption and decryption methods  etc...    e
        } catch (IOException ex){ // Catch any IOException here that might occur during accept operation - Usually because port wasn’t available. The program should either handle this exception or terminate itself somehow so it does not end up hanging when run in a loop  
            System.out.println("Failed to listen on port " + socket.getLocalPort()+"."); // If above IOException is caught, print stack trace for debugging purpose only - This line should never get executed as we are catching the exception here using try-catch blocks but it's included if you want a general way handle exceptions in case of unsuccessful operation (like terminating)
            System.exit(1); //Exit process gracefully on Unhandled Exception  }   else {// If no IOException is thrown, continue with SSL operations for the next step and setup ssl context etc...}    catch block can also include a print statement or method to handle exceptions in case of unsuccessful operation