import java.io.*;
import java.net.*;

public class java_26129_SocketServer_A03 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            // Step 1: Setup the server socket
            serverSocket = new ServerSocket(4444);
            System.out.println("Server is listening on port: 4444");

            // Step 2: Wait for client to connect
            socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());

            // Step 3: Create input and output streams
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Step 4: Communication with the client
            while (true) {
                // Read the message from the client
                String message = in.readUTF();
                System.out.println("Received from client: " + message);

                // Echo the message back to the client
                out.writeUTF("Server received: " + message);
                out.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Step 5: Close the connection
            if (socket != null) {
                try { socket.close(); } catch (IOException e) { /* can't do anything */ }
            }
            if (serverSocket != null) {
                try { serverSocket.close(); } catch (IOException e) { /* can't do anything */ }
            }
        }
    }
}