import java.io.*;
import java.net.*;

public class java_38403_SocketServer_A03 {
    private int port = 8080;
    private ServerSocket server;

    public void startServer() throws IOException {
        server = new ServerSocket(port);
        System.out.println("Server started on port " + port);

        while (true) {
            Socket client = server.accept();
            System.out.println("Client connected: " + client.getRemoteSocketAddress());

            DataInputStream input = new DataInputStream(client.getInputStream());
            DataOutputStream output = new DataOutputStream(client.getOutputStream());

            String message = input.readUTF();
            if (isInjectionAttack(message)) {
                System.out.println("Injection attack detected, message: " + message);
                message = "Injection attack detected, message: " + message;
            }

            output.writeUTF(message);
            output.flush();
            client.close();
        }
    }

    private boolean isInjectionAttack(String message) {
        // This is a simple example of an injection attack.
        // In a real application, you would need to implement a more sophisticated
        // method of detecting and mitigating injection attacks.
        return message.contains("DROP TABLE");
    }

    public static void main(String[] args) throws IOException {
        SocketServer server = new SocketServer();
        server.startServer();
    }
}