import java.io.*;
import java.net.*;

public class java_11177_SocketServer_A03 {
    private static int port = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);

        System.out.println("Server is running on port: " + port);

        while (true) {
            Socket clientSocket = serverSocket.accept();

            System.out.println("New client connected: " + clientSocket.getInetAddress().getHostAddress());

            DataInputStream inputStream = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream());

            String message = inputStream.readUTF();
            System.out.println("Received message: " + message);

            String response = processMessage(message);
            outputStream.writeUTF(response);
            outputStream.flush();

            clientSocket.close();
        }
    }

    private static String processMessage(String message) {
        // Example of a security-sensitive operation:
        // Inject code here using a method like this
        // String injection = "Injection code here";
        // return message + injection;

        return message;
    }
}