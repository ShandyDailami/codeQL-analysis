import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_40475_SocketServer_A01 {
    private static final int SERVER_PORT = 4445;
    private static ServerSocket serverSocket;

    public static void main(String[] args) {
        // Create a server socket and listen on the specified port
        try {
            serverSocket = new ServerSocket(SERVER_PORT);
            System.out.println("Server is listening on port " + SERVER_PORT);

            while (true) {
                // Accept a client connection
                Socket clientSocket = serverSocket.accept();
                System.out.println("New connection accepted from " + clientSocket.getRemoteSocketAddress());

                // Create a new thread to handle communication with the client
                new SocketHandler(clientSocket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Define a static inner class to handle communication with a client
    private static class SocketHandler extends Thread {
        private Socket socket;

        public java_40475_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            // Read data from the client and perform operations on it
            try {
                while (true) {
                    byte[] buffer = new byte[1024];
                    int bytesRead = socket.getInputStream().read(buffer);
                    if (bytesRead == -1) break;  // End of connection

                    String message = new String(buffer, 0, bytesRead);
                    System.out.println("Received: " + message);

                    // Perform operations on the received data, here just echoing back
                    String response = "Server echo: " + message;
                    socket.getOutputStream().write(response.getBytes());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Close the connection
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}