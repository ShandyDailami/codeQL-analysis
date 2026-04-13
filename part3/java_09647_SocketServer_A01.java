import java.io.*;
import java.net.*;

public class java_09647_SocketServer_A01 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            // 1. Create a server socket
            serverSocket = new ServerSocket(4444);
            System.out.println("Server started on port 4444");

            // 2. Accept incoming connections
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                // 3. Create input and output streams
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                // 4. Handle client requests
                String request = in.readLine();
                System.out.println("Received request: " + request);

                // 5. Respond to client
                String response = "Hello, Client!";
                out.writeBytes(response + "\n");

                // 6. Close connections
                socket.close();
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
}