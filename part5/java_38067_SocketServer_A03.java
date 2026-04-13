import java.io.*;
import java.net.*;

public class java_38067_SocketServer_A03 {
    private static int serverPort = 12345;
    private static ServerSocket serverSocket = null;

    public static void main(String[] args) {
        try {
            serverSocket = new ServerSocket(serverPort);
            System.out.println("Server started at port " + serverPort);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected from " + clientSocket.getRemoteSocketAddress());

                DataInputStream input = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream());

                String message = input.readUTF();
                System.out.println("Received message: " + message);

                String response = processInjection(message);
                output.writeUTF(response);
                output.flush();

                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String processInjection(String input) {
        // This is a very basic example of an injection.
        // It does not actually do anything harmful, but it's an example.
        // Please note that this is a security vulnerability and should not be used in a real-world application.
        return "You said: " + input;
    }
}