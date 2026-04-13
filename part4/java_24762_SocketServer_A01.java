import java.io.*;
import java.net.*;

public class java_24762_SocketServer_A01 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server is running on port " + PORT);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());

            DataInputStream input = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream());

            String request = input.readUTF();
            System.out.println("Received: " + request);

            String response = processRequest(request);
            output.writeUTF(response);
            output.flush();

            clientSocket.close();
        }
    }

    private static String processRequest(String request) {
        // Here we can add code to check if request is broken and return a response.
        // For the purpose of this example, let's assume the request is not broken.
        return "Hello, Client!";
    }
}