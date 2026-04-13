import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_33289_SocketServer_A07 {

    private final static int PORT = 8888;
    private final static String CLIENT_IDENTIFIER = "CLIENT_IDENTIFIER";

    public static void main(String[] args) throws Exception {

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        SSLServerSocket serverSocket = (SSLServerSocket) new SSLServerSocket(PORT, null, null, InetAddress.getByName("127.0.0.1"));
        System.out.println("Server listening on port: " + PORT);

        while (true) {
            final SSLSocket socket = (SSLSocket) serverSocket.accept();
            socket.setSoTimeout(10000);
            socket.setKeepAlive(true);
            socket.setReceiveBufferSize(1024);
            socket.setSendBufferSize(1024);

            System.out.println("Accepted connection from: " + socket.getRemoteSocketAddress());

            executorService.execute(new SocketHandler(socket));
        }
    }

    static class SocketHandler implements Runnable {
        private final SSLSocket socket;

        SocketHandler(SSLSocket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            // Handling the socket here. For example, you can read data, send data, etc.
            try {
                // Perform authentication
                if (authenticate(socket)) {
                    // Handle the socket if authentication is successful
                    socket.getInputStream();
                } else {
                    // Close the socket if authentication fails
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private boolean authenticate(SSLSocket socket) {
            // Implement your authentication logic here.
            // For simplicity, we are checking if the CLIENT_IDENTIFIER is the same as the server identifier
            // in this case. You should replace this with your own logic.
            try {
                byte[] bytes = socket.getInputStream().readNBytes(CLIENT_IDENTIFIER.length());
                return CLIENT_IDENTIFIER.equals(new String(bytes));
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
    }
}