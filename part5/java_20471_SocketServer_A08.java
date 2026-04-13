import java.io.*;
import java.net.*;

public class java_20471_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(1234); // listen on port 1234
        System.out.println("Server started on port 1234");

        while (true) {
            Socket socket = server.accept(); // wait for client connection
            System.out.println("Client connected");

            // create input and output streams
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // read message from client
            String message = in.readUTF();
            System.out.println("Received: " + message);

            // send back a message to the client
            String response = "Server received your message";
            out.writeUTF(response);

            // close the connection
            socket.close();
       
        }
    }
}