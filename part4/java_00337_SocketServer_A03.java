import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_00337_SocketServer_A03 {

    private static final int PORT = 8080;
    private static final String CLIENT_IDENTIFIER = "Client";

    public static void main(String[] args) throws IOException {
        // Create a pool of threads for handling multiple clients
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        // Start SSL server
        SSLServerSocket serverSocket = null;
        try {
            serverSocket = (SSLServerSocket) new SSLServerSocket(PORT, null, null, CLIENT_IDENTIFIER.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        while (true) {
            try {
                // Wait for client connection
                SSLSocket sslSocket = (SSLSocket) serverSocket.accept();
                // Make sure client's SSL certificate is valid
                if (!sslSocket.getRemoteCertificate().getSubjectDN().equals(sslSocket.getLocalCertificate().getSubjectDN())) {
                    throw new IOException("Invalid certificate!");
                }
                // Use ThreadPoolExecutor for handling each client
                executorService.execute(new SocketHandler(sslSocket));
            } catch (IOException e) {
                e.printStackTrace();
                serverSocket.close();
                System.exit(1);
            }
        }
    }

    static class SocketHandler implements Runnable {
        private Socket socket;
        private ObjectInputStream inputStream;
        private ObjectOutputStream outputStream;

        public java_00337_SocketServer_A03(Socket socket) {
            this.socket = socket;
            try {
                outputStream = new ObjectOutputStream(socket.getOutputStream());
                inputStream = new ObjectInputStream(socket.getInputStream());
            } catch (IOException e) {
                e.printStackTrace();
                try {
                    socket.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }

        @Override
        public void run() {
            try {
                // Read and validate data from client
                String message = inputStream.readUTF();
                // TODO: Add validation logic
                // TODO: Process the message

                // Send response back to client
                outputStream.writeUTF("Success!");
                outputStream.flush();

            } catch (IOException e) {
                e.printStackTrace();
                try {
                    socket.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}