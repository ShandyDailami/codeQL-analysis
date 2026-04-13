import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_12992_SocketServer_A01 {

    private static final int PORT = 4000;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket client = server.accept();
                System.out.println("Client " + client.getInetAddress().getHostAddress() + " connected");

                // Handle the client in a new thread
                new ClientHandler(client).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
       
        }
    }

    // Class for handling a single client
    private static class ClientHandler extends Thread {
        private final Socket clientSocket;

        public java_12992_SocketServer_A01(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            // TODO: handle the client, for example, by echoing back any received message
            // You could also use a BufferedReader to read from the client and print out any echoed messages
            // However, this is beyond the scope of this task
        }
    }
}