import java.io.*;
import java.net.*;

public class java_13390_SocketServer_A03 {

    private ServerSocket server;

    public void start(int port) throws IOException {
        server = new ServerSocket(port);
        System.out.println("Server started on port " + port);

        while (true) {
            Socket client = server.accept();
            System.out.println("Client connected from " + client.getRemoteSocketAddress());

            DataInputStream input = new DataInputStream(client.getInputStream());
            DataOutputStream output = new DataOutputStream(client.getOutputStream());

            String userInput = input.readUTF();

            System.out.println("Received: " + userInput);

            // In a real-world application, you would want to sanitize and validate user inputs.
            // For simplicity, we'll just echo them back to prevent injection.
            String response = "Received: " + userInput;
            output.writeUTF(response);
            output.flush();

            client.close();
       
        }
    }

    public void stop() throws IOException {
        server.close();
    }

    public static void main(String[] args) throws IOException {
        SocketServer server = new SocketServer();
        server.start(8080);
    }
}