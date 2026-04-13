import java.io.*;
import java.net.*;

public class java_40667_SocketServer_A07 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080); // create a server socket on port 8080
        System.out.println("Waiting for client on port 8080...");

        while (true) {
            Socket socket = serverSocket.accept(); // accept a client connection
            System.out.println("Client connected!");

            // create input and output streams
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // handle client connection
            String clientMessage = in.readUTF();
            System.out.println("Received: " + clientMessage);

            // respond with a greeting message
            String serverMessage = "Hello, client!";
            out.writeUTF(serverMessage);
            System.out.println("Sent: " + serverMessage);

            // close connection
            socket.close();
        }
    }
}