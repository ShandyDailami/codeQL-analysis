import java.io.*;
import java.net.*;

public class java_29500_SocketServer_A08 {
    private static final int DEFAULT_PORT = 1234;
    private static ServerSocket server;

    private java_29500_SocketServer_A08() {}

    public static void main(String[] args) {
        int port = args.length > 0 ? Integer.parseInt(args[0]) : DEFAULT_PORT;
        startServer(port);
    }

    private static void startServer(int port) {
        try {
            server = new ServerSocket(port);
            System.out.println("Server started at port " + port);

            while (true) {
                handleClient(server.accept());
            }
        } catch (IOException ex) {
            System.err.println("Failed to start server: " + ex.getMessage());
            ex.printStackTrace();
        } finally {
            if (server != null) {
                server.close();
            }
        }
    }

    private static void handleClient(Socket clientSocket) throws IOException {
        System.out.println("New client connected");

        DataInputStream in = new DataInputStream(clientSocket.getInputStream());
        DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

        String clientMessage;
        while ((clientMessage = in.readUTF()) != null) {
            System.out.println("Received: " + clientMessage);
            out.writeUTF("Message received: " + clientMessage);
        }

        clientSocket.close();
    }
}