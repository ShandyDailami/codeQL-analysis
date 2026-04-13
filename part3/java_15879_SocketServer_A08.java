import java.io.*;
import java.net.*;

public class java_15879_SocketServer_A08 {
    private static int port = 1234;

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server started on port " + port);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected: " + socket.getRemoteSocketAddress());

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            String message = input.readUTF();
            System.out.println("Received: " + message);

            // Checking if the received message is 'exit' to disconnect the client
            if (message.equals("exit")) {
                System.out.println("Client disconnected.");
                socket.close();
            } else {
                // Sending back the message to the client
                output.writeUTF("Hello client, you said: " + message);
                output.flush();
            }
        }
    }
}