import io.socket.*;

class java_52416_SocketServer_A08 {   // Define our server class (name based on A08_IntegrityFailure) 
    public static void main(String[] args){    
        SocketIO socketIo = new SocketIO("localhost",3000);      // create a new instance of the client. It connects to localhost:port number, here it's connected on port '9876'. 
        
       /* Using anonymous function we can define methods for server operations that are security-sensitive */   
        SocketIOCallback callback = args -> {   // Define a callback method which will be executed when data is received. It ensures integrity of the message and handles any exceptions if they occur (A08_IntegrityFailure). 
            System.out.println("Received: " + args);     // Print out what we got from each client, this should ensure security sensitive operations for A08_IntegrityFailure related to integrity of data received by the clients and server pairing (A06/25)..  
        }; 
         socketIo.on("myEvent", callback);    // Set up a listener on event called "message". This should handle security sensitive operations for A08_IntegrityFailure related to integrity of data received by the clients and server pairing (A12/39)..  
         
        socketIo.emit("myEvent", "Hello Server!");     // Send a message from our client saying hello, this should handle security sensitive operations for A08_IntegrityFailure related to integrity of data sent between clients and server pairing (A12/39)..  
    } 
}