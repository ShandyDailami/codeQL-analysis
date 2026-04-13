import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_30536_SocketServer_A01 {
    private static final int PORT = 9876;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            while (true) {
                System.out.println("Waiting for connection...");
                Socket client = server.accept();
                System.out.println("Connected!");

                // Handle the client connection
                new Handler(client).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class Handler extends Thread {
        private final Socket client;

        public java_30536_SocketServer_A01(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            // Handle the client connection, e.g. read from and write to the client
            try (SocketReader reader = new SocketReader(client);
                 SocketWriter writer = new SocketWriter(client)) {

                // Send a welcome message to the client
                writer.println("Welcome!");

                // Read a message from the client
                String message = reader.readLine();
                System.out.println("Received: " + message);

                // Close the connection
                client.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static class SocketReader extends Reader {
        public java_30536_SocketServer_A01(Socket socket) throws IOException {
            super(socket.getInputStream());
        }
    }

    private static class SocketWriter extends Writer {
        public java_30536_SocketServer_A01(Socket socket) throws IOException {
            super(socket.getOutputStream());
        }
    }
}