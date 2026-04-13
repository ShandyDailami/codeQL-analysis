import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_34432_SocketServer_A07 {

    public static void main(String[] args) throws IOException {
        // Create a new server socket and listen on port 1234
        ServerSocket server = new ServerSocket(1234);
        System.out.println("Server started on port 1234");

        // Continuously listen for connections
        while (true) {
            // Accept a new client connection
            Socket client = server.accept();
            System.out.println("New client connected from " + client.getRemoteSocketAddress());

            // Create a new thread for this client
            new ClientHandler(client).start();
        }
    }

    // A thread for handling individual client requests
    private static class ClientHandler extends Thread {
        private Socket client;

        public java_34432_SocketServer_A07(Socket client) {
            this.client = client;
        }

        public void run() {
            try {
                // Get the input and output streams
                InputStream in = client.getInputStream();
                OutputStream out = client.getOutputStream();

                // Read a message from the client
                byte[] bytes = new byte[1024];
                int len = in.read(bytes);
                if (len < 0) {
                    System.out.println("Client disconnected");
                } else {
                    // Convert the message to a string and send it back
                    String message = new String(bytes, 0, len);
                    out.write(message.getBytes());
                }

                // Close the connection
                client.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}