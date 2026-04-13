import java.io.*;
import java.net.*;

public class java_31334_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);
        System.out.println("Server started at port 8000");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("New client connected");

            // Creating a new thread to handle communication
            new Thread(() -> handleClient(socket)).start();
        }
    }

    private static void handleClient(Socket socket) throws IOException {
        try (socket;
             BufferedReader in = new BufferedReader(
                     new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);

                // Simple example of injection
                if (message.contains("injection")) {
                    System.out.println("Injection detected, aborting connection");
                    socket.close();
                    return;
                }

                out.println("Echo: " + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}