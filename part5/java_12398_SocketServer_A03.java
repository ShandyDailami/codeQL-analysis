import java.io.*;
import java.net.*;
import java.util.*;

public class java_12398_SocketServer_A03 {
    private static final int PORT = 9876;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started on port " + PORT);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected: " + socket.getRemoteSocketAddress());

            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            String clientMessage = input.readUTF();
            System.out.println("Received: " + clientMessage);

            String serverMessage = processClientMessage(clientMessage);
            output.writeUTF(serverMessage);
            output.flush();
        }
    }

    private static String processClientMessage(String clientMessage) {
        // This is a simple example of a command injection attack.
        // It is not a real security-sensitive operation but it demonstrates the concept.
        // The goal is to inject a command that the server can execute.
        // In a real application, the server should not directly execute user input.

        // You would replace this with your own command execution logic.
        // For example, if the client sends "runupdate", we could assume that the server has an update function.
        String command = clientMessage.substring(0, clientMessage.indexOf(" "));

        if ("runupdate".equals(command)) {
            // Run the update function on the server.
            // This is a very simplistic example, and a real application would need a more complex mechanism.
            System.out.println("Running update...");
            return "Update successful";
        }

        return "Unknown command";
    }
}