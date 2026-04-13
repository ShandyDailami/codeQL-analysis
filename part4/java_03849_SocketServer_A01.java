import java.io.*;
import java.net.*;

public class java_03849_SocketServer_A01 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            // Create server socket and listen on port 1234
            serverSocket = new ServerSocket(1234);
            System.out.println("Server is listening on port 1234");

            // Wait for a client to connect
            socket = serverSocket.accept();
            System.out.println("Client connected");

            // Create input and output streams
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Read message from client
            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);

                // Reply with same message
                out.println(message);
            }

            // Close the connection
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Always close the server socket
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