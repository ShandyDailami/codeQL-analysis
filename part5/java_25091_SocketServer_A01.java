import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_25091_SocketServer_A01 {

    private static final String LOCALHOST = "localhost";
    private static final int PORT = 9999;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket clientSocket = null;

        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server is listening on port: " + PORT);

            while (true) {
                clientSocket = serverSocket.accept();
                System.out.println("New client connected from: " + clientSocket.getRemoteSocketAddress());

                // Here we implement a simple password check.
                // In a real-world application, you would want to use a more secure mechanism.
                String password = "secret";
                String received = new String(clientSocket.getInputStream().readNBytes(password.length()));

                if (!password.equals(received)) {
                    System.out.println("Invalid password. Connection closed.");
                    clientSocket.close();
                    continue;
                }

                // We have a valid password, proceed with communication.
                // Here we assume that the client is a text-based protocol and wants to read and write strings.
                new ReadWriteThread(clientSocket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try { serverSocket.close(); } catch (IOException e) { /* can't do anything */ }
            }
            if (clientSocket != null) {
                try { clientSocket.close(); } catch (IOException e) { /* can't do anything */ }
            }
        }
    }

    private static class ReadWriteThread extends Thread {
        private final Socket socket;

        ReadWriteThread(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                // Read from client, write to client.
                byte[] bytes = new byte[1000];
                int bytesRead = socket.getInputStream().read(bytes);
                if (bytesRead < 0) {
                    System.out.println("Closed connection by client.");
                    return;
                }
                socket.getOutputStream().write(bytes, 0, bytesRead);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}