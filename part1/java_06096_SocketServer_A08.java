import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_06096_SocketServer_A08 {
    private static final int DEFAULT_PORT = 12345;
    private static ServerSocket serverSocket;

    public static void main(String[] args) {
        try {
            serverSocket = new ServerSocket(DEFAULT_PORT);
            System.out.println("Server started on port: " + DEFAULT_PORT);

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New connection accepted from " + socket.getRemoteSocketAddress());

                // Here you can add code to handle the socket connection in a secure and meaningful way
                // For example, you can add a data integrity check and refuse to accept the connection if the data integrity check fails
                // Note that this is a simple example and a real-world application would need to handle multiple connections,
                // and may need to use threads for each connection.
                if (checkDataIntegrity(socket)) {
                    new Thread(new ClientHandler(socket)).start();
                } else {
                    System.out.println("Data integrity check failed for " + socket.getRemoteSocketAddress());
                    socket.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static boolean checkDataIntegrity(Socket socket) {
        // Here you can add code to perform a data integrity check on the socket connection
        // For example, you can check the content of the socket to see if it contains valid data
        // Note that this is a simple example and a real-world application would need to perform more complex checks
        // This could involve validating the data against a predefined set of rules, or performing a hash check on the data
        return true;
    }

    private static class ClientHandler implements Runnable {
        private Socket socket;

        public java_06096_SocketServer_A08(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Handle the socket connection here
            // For example, you could read data from the socket and send it back to the client
            // You can then close the socket once you're done with the data
        }
    }
}