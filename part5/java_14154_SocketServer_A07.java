import java.io.*;
import java.net.*;

public class java_14154_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080); // open port 8080
        System.out.println("Server is listening on port 8080...");

        while (true) {
            Socket socket = server.accept(); // wait for a client to connect

            System.out.println("Client connected");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String clientMessage = in.readUTF(); // read client's message
            System.out.println("Received: " + clientMessage);

            String response = "Hello, client!"; // prepare response
            out.writeUTF(response); // send response back

            socket.close(); // close the connection
        }
    }
}