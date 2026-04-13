import java.io.*;
import java.net.*;
import java.util.*;

public class java_16349_SocketServer_A08 {

    private static int DEFAULT_PORT = 8080;
    private static ServerSocket serverSocket;

    public static void main(String[] args) {

        try {
            System.out.println("Starting server on port " + DEFAULT_PORT);
            serverSocket = new ServerSocket(DEFAULT_PORT);
            while (true) {
                handleClient(serverSocket.accept());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void handleClient(Socket clientSocket) {
        try {
            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

            String request = in.readUTF();
            System.out.println("Received: " + request);

            // Here is where we would typically decrypt the request, 
            // and then sanitize the request before processing it.
            // For simplicity, let's say that the request is correct.

            // We'll just send back the same request to the client
            out.writeUTF(request);
            out.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}