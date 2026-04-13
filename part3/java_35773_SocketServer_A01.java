import java.io.*;
import java.net.*;

public class java_35773_SocketServer_A01 {

    private static final String SERVER_MSG = "Server listening on port ";

    public static void main(String[] args) throws IOException {

        int port = 12345; // Specify your port

        ServerSocket serverSocket = new ServerSocket(port);

        System.out.println(SERVER_MSG + port);

        while (true) {
            Socket clientSocket = serverSocket.accept();

            System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());

            // Create a new thread for each connected client
            new ClientHandler(clientSocket).start();
        }
    }

    // Inner class for handling each client
    private static class ClientHandler extends Thread {
        private final Socket socket;
        private final DataInputStream in;
        private final DataOutputStream out;

        public java_35773_SocketServer_A01(Socket socket) {
            this.socket = socket;
            try {
                in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());
            } catch (IOException e) {
                e.printStackTrace();
                closeConnection();
            }
        }

        public void run() {
            try {
                String message;
                while ((message = in.readUTF()) != null) {
                    System.out.println("Received: " + message);
                    // Process the message here
                    // For example, just echo the message back
                    out.writeUTF(message);
                    out.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
                closeConnection();
            }
        }

        private void closeConnection() {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}