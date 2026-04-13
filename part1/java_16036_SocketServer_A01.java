import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_16036_SocketServer_A01 {
    private static final String SERVER_NAME = "SecureSocketServer";
    private static final int PORT = 5000;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server started at port: " + PORT);
            while (true) {
                Socket client = server.accept();
                System.out.println("Client connected from: " + client.getRemoteSocketAddress());

                // Start a new thread to handle communication with the client
                new HandleClientThread(client).start();
            }
        } catch (IOException e) {
            System.out.println("Server failed to start. Exiting.");
            e.printStackTrace();
        }
    }

    // A thread to handle communication with a client
    private static class HandleClientThread extends Thread {
        private final Socket client;

        public java_16036_SocketServer_A01(Socket client) {
            this.client = client;
        }

        @Override
        public void run() {
            // Here you can add code to handle communication with the client
            // For simplicity, we'll just echo back any message received
            try (Socket connection = new Socket(client.getInetAddress(), PORT)) {
                connection.setSoTimeout(1000);
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = connection.getInputStream().read(buffer)) != -1) {
                    connection.getOutputStream().write(buffer, 0, bytesRead);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}