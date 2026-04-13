import java.io.*;
import java.net.*;

public class java_13916_SocketServer_A08 {

    private static final int PORT = 5000;

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {

            System.out.println("Server started. Waiting for connections on port " + PORT);

            while (true) {

                Socket socket = serverSocket.accept();

                System.out.println("A new client has connected");

                // Create a new thread to handle communication with the client
                Thread thread = new Thread(new ClientHandler(socket));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler implements Runnable {

        private final Socket socket;

        public java_13916_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {

                String clientMessage;
                while ((clientMessage = reader.readLine()) != null) {
                    System.out.println("Received: " + clientMessage);

                    // Simulate a security-sensitive operation related to A08_IntegrityFailure
                    if (clientMessage.equals("BadMessage")) {
                        writer.println("Security failure. Message ignored.");
                    } else {
                        writer.println("Message received: " + clientMessage);
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}