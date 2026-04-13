import java.io.*;
import java.net.*;

public class java_32086_SocketServer_A08 {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        while (true) {
            try {
                serverSocket = new ServerSocket(8080);
                System.out.println("Server started on port 8080");
                Socket socket = serverSocket.accept();

                // Create Streams
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                // Receive request
                String request = in.readUTF();
                System.out.println("Received request: " + request);

                // Process request
                String response = processRequest(request);

                // Send response
                out.writeUTF(response);
                out.flush();

                // Close connection
                socket.close();
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

    private static String processRequest(String request) {
        // Simulate a security-sensitive operation
        // Here we just return the same request for simplicity
        return request;
    }
}