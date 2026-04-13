import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_29685_SocketServer_A01 {

    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected");

                Thread thread = new Thread(new ClientHandler(clientSocket));
                thread.start();
            }
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }

    private static class ClientHandler implements Runnable {
        private final Socket clientSocket;

        public java_29685_SocketServer_A01(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            // Handle the client socket here.
            // In this case, we're not doing anything specific with the client socket,
            // but you could handle it here to add access control logic for A01_BrokenAccessControl.
        }
    }
}