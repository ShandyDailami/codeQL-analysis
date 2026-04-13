import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_32791_SocketServer_A01 {

    public static void main(String[] args) throws IOException {
        int port = 12345; // choose a port

        ServerSocket server = new ServerSocket(port);
        System.out.println("Server started at port " + port);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected from " + socket.getRemoteSocketAddress());

            // Create a new thread for each client
            new ClientHandler(socket).start();
        }
    }

    static class ClientHandler extends Thread {

        private Socket socket;

        public java_32791_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                // Receive a message from the client
                byte[] buffer = new byte[1024];
                socket.getInputStream().read(buffer);
                String message = new String(buffer, "UTF-8");

                System.out.println("Received message from client: " + message);

                // Send a response back to the client
                String response = "Message received, thank you!";
                socket.getOutputStream().write(response.getBytes("UTF-8"));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}