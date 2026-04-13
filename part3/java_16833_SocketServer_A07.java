import java.io.*;
import java.net.*;

public class java_16833_SocketServer_A07 {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(4444); // port number
            System.out.println("Waiting for client on port 4444");

            Socket socket = server.accept(); // accept client connection
            System.out.println("Connected to client");

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // read request from client
            String request = in.readUTF();
            System.out.println("Client says: " + request);

            // send response back to client
            String response = "Hello Client, Your request was successful.";
            out.writeUTF(response);
            System.out.println("Server says: " + response);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}