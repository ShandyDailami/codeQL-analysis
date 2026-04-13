import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_22469_SocketServer_A03 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            // Create a ServerSocket to listen on the given port.
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server started at port " + PORT + ".");

            while (true) {
                // Wait for a client to connect and create a new Socket for that connection.
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());

                // Create a new Thread to handle the client's request.
                new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Ensure the server socket is closed when the program ends.
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class ClientHandler extends Thread {
        private Socket clientSocket;

        public java_22469_SocketServer_A03(Socket socket) {
            this.clientSocket = socket;
        }

        public void run() {
            try {
                // Create a new InputStream to read the client's request.
                java.io.InputStream input = clientSocket.getInputStream();
                java.util.Scanner in = new java.util.Scanner(input);

                // Read the client's request and send back a response.
                String response = "Hello, client!";
                java.io.OutputStream output = clientSocket.getOutputStream();
                output.write(response.getBytes());

                // Close the streams.
                input.close();
                output.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}