import java.io.*;
import java.net.*;

public class java_01598_SocketServer_A03 {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080); // port number
        System.out.println("Waiting for client connections...");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected!");

            // Handle each client's request
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String request;
            while ((request = in.readLine()) != null) {
                if (request.equals("exit")) {
                    break;
                }
                System.out.println("Received: " + request);

                // Here you can add security-sensitive operations like encryption or decryption

                out.println("Server response: " + request);
            }

            socket.close();
            System.out.println("Client disconnected!");
        }
    }
}