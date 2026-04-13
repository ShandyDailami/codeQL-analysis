import java.net.*;
import java.io.*;

public class java_16998_SocketServer_A07 {
    private static final int port = 8080;

    public static void main(String[] args) throws IOException {
        // Step 1: Set up the server socket
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server is listening on port: " + port);

        while (true) {
            // Step 2: Wait for a client to connect
            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getRemoteSocketAddress());

            // Step 3: Handle the communication
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Step 4: Read from the input stream
            String message = in.readUTF();
            System.out.println("Client says: " + message);

            // Step 5: Write to the output stream
            out.writeUTF("Hello, client, you are authenticated!");

            // Step 6: Close the connection
            socket.close();
        }
    }
}