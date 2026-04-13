import java.net.*;
import java.io.*;

public class java_14106_SocketServer_A07 {
    private static final int PORT = 9090;
    private static int clientCount = 0;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(PORT);
        System.out.println("Server started at port: " + PORT);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected from: " + socket.getRemoteSocketAddress());

            // Authentication step
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            String clientInfo = dis.readUTF();

            if (authenticateClient(clientInfo)) {
                dos.writeUTF("Authentication successful.");
                dos.flush();
            } else {
                dos.writeUTF("Authentication failed.");
                dos.flush();
                socket.close();
                continue;
            }

            // Start a new thread for each client
            new ClientHandler(socket).start();
        }
    }

    private static boolean authenticateClient(String clientInfo) {
        // Simulate authentication by comparing clientInfo with a hardcoded value
        // In a real application, you would usually query a database or other authentication source
        return clientInfo.equals("hardcoded value");
    }

    private static class ClientHandler extends Thread {
        private Socket socket;
        private DataInputStream dis;
        private DataOutputStream dos;

        public java_14106_SocketServer_A07(Socket socket) {
            this.socket = socket;
            try {
                dis = new DataInputStream(socket.getInputStream());
                dos = new DataOutputStream(socket.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void run() {
            try {
                while (true) {
                    String message = dis.readUTF();
                    dos.writeUTF("Received: " + message);
                    dos.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}