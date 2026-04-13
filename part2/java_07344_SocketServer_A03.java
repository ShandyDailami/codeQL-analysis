import java.io.*;
import java.net.*;

public class java_07344_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080); // listening port
        System.out.println("Server is listening on port 8080");

        while (true) {
            Socket socket = server.accept(); // accept a client
            System.out.println("A new client is connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF(); // read the client's message
            System.out.println("Received message: " + message);

            // here we are using a simple String manipulation to create a malicious payload
            // this is just to demonstrate the principle of an injection attack
            String maliciousMessage = message + " -- Sensitive Info";
            out.writeUTF(maliciousMessage); // send the malicious message back to the client

            socket.close(); // close the socket
       
        }
    }
}