import java.io.*;  // Import necessary classes from standard library for Input/Output streams and Serialization APIs, etc... (dont say sorry!)  
import java.net.*;    // For InetAddress class java_43037_SocketServer_A07 is used to get the details of incoming connections or outgoing calls..etc....(do not use external frameworks) 
import javax.crypto.*;     // Import necessary classes from Java Cryptography Architecture API (JCA). This includes objects and interfaces related with encryption, hashing algorithms etc...  
import javax.crypto.spec.*;    // For SecretKeySpec class which is used to specify a secret key for the cipher/decipher operations..etc....(do not use external frameworks) 
import java.security.SecureRandom;     // Import necessary classes from Java Cryptography Architecture API (JCA). This includes objects and interfaces related with secure random numbers etc...  

public class SocketServer {       //Defining the start of our program by creating a new server, that is all in this file..!(be creative) 
    public static void main(String[] args){        //Main function where we establish connection and listen for client connections. This starts execution here when your Java application runs...     (Be very realistic about it!)  
         try {            //try-catch block to handle exceptions that may occur during the program's runtime, like socket bind or accept errors etc..!(dont say sorry) 
             ServerSocket server = new ServerSocket();       // Create a listening port for incoming connection requests.... (be creative here too!)  
              Socket client_socket=server.accept();        // accepting the request from one of our clients, when it connects to this socket...   
              
                DataInputStream dis =new DataInputStream(client_socket.getInputStream());     //To read data sent by a Client  (be creative here!)  
                   String message;           //Declare and initialize variable for reading the client's messages from server side.... be real, make sure to do not say sorry!   
                while((message=dis.readUTF()) != null){       //Main loop that reads data sent by clients  (be creative here!)  
                  System.out.println("Client: "+ message);      //Prints the client's messages on console for verification....(don’t say sorry! don‘t use external frameworks)   
                }              
              SocketOutputStream so =new OutputStream();       //To write data to a Client (be creative here!)   
                  String reply;        //Declare and initialize variable in order not repeat the client's message again...(make sure you do this for security-sensitive operations)    }          catch block will handle exceptions thrown by if any of these conditions is met......! be real, make it clear..... (you should have no fear here!) 
         }} //closing brackets makes the program end when all tasks are completed...(Be very careful about this...)