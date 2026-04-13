import java.io.*;
import java.net.*;

public class java_24923_SocketServer_A03 {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("Server started on port 8080");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // create input and output streams
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            // read client message
            String message = input.readUTF();
            System.out.println("Received message: " + message);

            // check for injection attacks
            if (isInjectionAttack(message)) {
                System.out.println("Detected injection attack, closing connection");
                output.writeUTF("Injection attack detected, closing connection");
                output.flush();
                socket.close();
                continue;
            }

            // respond to client
            String response = "Hello, " + message + "!";
            output.writeUTF(response);
            output.flush();
            socket.close();
        }
    }

    private static boolean isInjectionAttack(String message) {
        // check for specific injection patterns
        return message.contains("script") || message.contains("<script>") || message.contains("script>");
    }
}