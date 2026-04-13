import java.net.*;
import java.io.*;

public class java_11432_SocketServer_A08 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080); // create server socket on port 8080
            System.out.println("Server started on port 8080");

            while (true) {
                Socket socket = serverSocket.accept(); // accept a client socket
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                // read request from client
                String request = in.readUTF();
                System.out.println("Received request: " + request);

                // send response to client
                String response = "Hello, " + request + ". Welcome to the server!";
                out.writeUTF(response);
                out.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}