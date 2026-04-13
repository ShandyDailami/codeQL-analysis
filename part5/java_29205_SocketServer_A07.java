import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_29205_SocketServer_A07 {

    private static final int PORT = 8080;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port: " + PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());

                // Start a new thread for each client
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.out.println("Server could not listen on port: " + PORT);
            e.printStackTrace();
        }
    }

    private static class ClientHandler extends Thread {
        private Socket socket;

        public java_29205_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // TODO: Implement your authentication logic here
            // For this example, we'll just check if the client's IP address matches a specific one
            String clientIP = socket.getInetAddress().getHostAddress();

            if (clientIP.equals("127.0.0.1")) {
                // Authentication successful, start communication
                // TODO: Implement your communication logic here
            } else {
                // Authentication failed
            }

            // Close the socket connection
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}