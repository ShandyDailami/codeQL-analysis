import java.io.*;
import java.net.*;

public class java_28405_SocketServer_A01 {
    private static final String SERVER_HOST = "127.0.0.1";
    private static final int SERVER_PORT = 3456;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(SERVER_PORT, 100, InetAddress.getByName(SERVER_HOST));

            System.out.println("Server is listening on port: " + SERVER_PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected: " + clientSocket.getRemoteSocketAddress());

                DataInputStream in = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

                // Read the message from the client
                String message = in.readUTF();
                System.out.println("Received message: " + message);

                // Send the message back to the client
                out.writeUTF("Message received: " + message);
                out.flush();

                clientSocket.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}