import java.io.*;
import java.net.*;

public class java_28037_SocketServer_A08 {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket();
        server.bind(new InetSocketAddress(SERVER_ADDRESS, SERVER_PORT));

        System.out.println("Server started. Listening for connections on " + SERVER_ADDRESS + ":" + SERVER_PORT);

        while (true) {
            Socket clientSocket = server.accept();

            System.out.println("Accepted new connection from " + clientSocket.getRemoteSocketAddress());

            // Here we create a new thread for each client.
            // This is a simplistic approach and real-world applications would typically use a thread pool.
            Thread clientHandler = new Thread(new ClientHandler(clientSocket));
            clientHandler.start();
        }
    }

    static class ClientHandler implements Runnable {
        private final Socket clientSocket;

        public java_28037_SocketServer_A08(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try (BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                String message;

                while ((message = in.readLine()) != null) {
                    System.out.println("Received message: " + message);

                    // Adding security-sensitive operation here.
                    // In a real-world scenario, this operation should be implemented in a secure manner.
                    if (message.equals("BYE")) {
                        out.println("Goodbye! Have a great day!");
                        break;
                    }

                    out.println("Echo: " + message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}