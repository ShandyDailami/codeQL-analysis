import java.io.*;
import java.net.*;
import java.util.*;

public class java_37744_SocketServer_A03 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            String message = in.readUTF();
            System.out.println("Received: " + message);

            String response = handleRequest(message);
            out.writeUTF(response);
            out.flush();

            socket.close();
        }
    }

    private static String handleRequest(String request) {
        // This is a simple example of a SQL injection vulnerability.
        // This is not a real-world security example.
        // It's only meant to demonstrate injection.
        String[] commands = request.split(" ");
        if (commands[0].equals("execute")) {
            String command = commands[1];
            if (command.equals("drop table users;")) {
                return "Command executed successfully.";
            } else {
                return "Invalid command.";
            }
        } else {
            return "Invalid request.";
        }
    }
}