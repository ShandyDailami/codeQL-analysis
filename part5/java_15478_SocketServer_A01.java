import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_15478_SocketServer_A01 {

    private static final int SERVER_PORT = 8000;

    public static void main(String[] args) {
        // Step 1: Initialize server socket
        ServerSocket serverSocket = null;

        try {
            // Step 2: Initialize server socket
            serverSocket = new ServerSocket(SERVER_PORT);
            System.out.println("Server started at port " + SERVER_PORT);

            while (true) {
                // Step 3: Accept client connection
                Socket socket = serverSocket.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Step 4: Perform server-side operations
                // (For this example, we're just echoing back the client's messages)
                new EchoThread(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Step 5: Close server socket
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Define a thread for handling each client connection
    private static class EchoThread extends Thread {
        private Socket socket;

        public java_15478_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                // Step 6: Create an input and output stream
                // (We'll use these to read from and write to the client)
                // (We'll also use these to handle any error cases)
                socket.getInputStream();
                socket.getOutputStream();

                // Step 7: Read from the client, and write to the client
                while (true) {
                    // TODO: Handle reading from the client
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}