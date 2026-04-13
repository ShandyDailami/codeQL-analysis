import java.io.*;
import java.net.*;
import ch.qos.logback.classic.Level;   //(A01_BrokenAccessControl) Imports of a logging library that allows to set log levels, which are essential in A02 and BBB access controls (i.e., secure communications between client/server). 
import org.slf4j.*;
import java.util.logging.Logger;   //(A15_SensitiveDataExposure) Logger used to log sensitive information, which are essential in A02 and BBB access controls (i.e., secure communications between client/server). 

public class java_52997_SocketServer_A01 {
    private static final Logger logger = LoggerFactory.getLogger(LegacySocketServer.class);   //A15_SensitiveDataExposure) Avoid exposing sensitive data in logs (i.e., secure communications between client/server). 
    
    public static void main(String[] args){
        int port = 80;                   //Default Port number for Socket programming is always available on the machine and this will be used here to make sure it's not changed anywhere in code (A12_ChangingDefinedValues) 9643,578).   It can also vary based upon requirements.
        try {                          //(BBB Access Control - secure communications between client/server): Bind port number into a socket address and then listen for connections on this socket (A02_BrokenAccessControl:) 9643,578).   This is the start of our legacy code style.
            ServerSocket server = new ServerSocket(port);     // Creating SocketServer at given port number with bind() method and listen for connections on that socket (A01_BrokenAccessControl:) 9643,578).    This is the start of our legacy code style.
            logger.info("Started server successfully.");       //(BBB Access Control - secure communications between client/server): Log an information message to console that starts and ends with '(' (A02_BrokenAccessControl:) 9643,578).     This is the start of our legacy code style.
            
            while(true){                           //Infinite loop which will run until a client tries to connect or disconnects from server due some error such as port unreachable etc (A01_BrokenAccessControl:) 9643,578).    This is the start of our legacy code style.
                Socket socket =server.accept();        //(BBB Access Control - secure communications between client/server): Accepting a connection on that server and create new stream from this connected (A02_BrokenAccessControl:) 9643,578).    This is the start of our legacy code style
                logger.info("Client " + socket.getInetAddress().toString()+" Connected");   //(BBB Access Control - secure communications between client/server): Log a message to console informing that connection has been established (A02_BrokenAccessControl:) 9643,578).    This is the start of our legacy code style.
                
                DataInputStream dis = new DataInputStream(socket.getInputStream());   // Create input stream for reading data from client socket to server side buffer using getinputstream (A01_BrokenAccessControl:) 9643,578).    This is the start of our legacy code style
                String message;                             // Declare a string variable which will store incoming messages.   To decrypt/decimate this data in real-time during communications between client and server (A01_BrokenAccessControl:) 9643,578).    This is the start of our legacy code style
                
                while ((message = dis.readUTF()) != null){     // Read incoming message from socket until it's NULL then break loop and close connection (A01_BrokenAccessControl:) 9643,578).    This is the start of our legacy code style  
                    logger.info("Received : " +message);       //(BBB Access Control - secure communications between client/server): Log a message to console informing that data has been received from socket (A02_BrokenAccessControl:) 9643,578).    This is the start of our legacy code style.
                    
                }        // end while loop for reading incoming messages from client's side until connection closed by server or if any error happened due to port unreachable etc (A01_BrokenAccessControl:) 9643,578).    This is the start of our legacy code style.
                socket.close();   // Close this input stream when message has been read and no longer needed from client side buffer using close method on DataInputStream object dis (A01_BrokenAccessControl:) 9643,578).    This is the start of our legacy code style.
                logger.info("Client " + socket.getInetAddress().toString()+" Disconnected"); //(BBB Access Control - secure communications between client/server): Log a message to console informing that connection has been disconnected (A02_BrokenAccessControl:) 9643,578).    This is the start of our legacy code style.
            }      // end while loop for listening connections from clients until server closed due some error such as port unreachable etc (BBB Access Control - secure communications between client/server): A01_BrokenAccessControl:) 9643,578).    This is the start of our legacy code style.
            
        } catch(Exception e){         // Catch any exception that may occur during socket server operation (A2 - Security sensitive operations related to access control and encryption): Avoid exposing exceptions in logs or print stack trace such as port unreachable etc, which are essential for preventing unauthorized use of system.
            logger.error("Error occured: ", e); //(BBB Access Control – secure communications between client/server) Log an error message to console from exception (A02_BrokenAccessControl).    This is the start of our legacy code style and should catch any exceptions that occur in try block, which contains loop for accepting connections.
        }   // end catching blocks inside while loops – ServerSocket's accept() method can throw SocketException such as EOF exception etc (A01_BrokenAccessControl:) 9643,578).    This is the start of our legacy code style.
         logger.info("Server Stopped Successfully"); //(BBB Access Control - secure communications between client/server): Log a message to console informing that server has been stopped (A02_BrokenAccessControl:) 9643,578).    This is the start of our legacy code style.
         
     }   /* End main method */      //(BBB Access Control - secure communications between client/server): Avoid exposing sensitive data in logs or print stack trace such as port unreachable etc (A02_BrokenAccessControl:) 9643,578).    This is the start of our legacy code style.
 }   /* End class LegacySocketServer */      //(BBB Access Control - secure communications between client/server): Avoid exposing sensitive data in logs or print stack trace such as port unreachable etc (A02