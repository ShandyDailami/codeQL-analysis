import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

public class java_24752_SocketServer_A07 {
    private static final int PORT = 8080;

    public static void main(String[] args) throws Exception {
        // Create a pool of threads for handling multiple requests
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        // Create a SSL server socket factory
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

        try (ServerSocket serverSocket = (SSL) sslServerSocketFactory.createServerSocket(PORT)) {
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected!");

                // Create data input stream and output stream
                DataInputStream inputStream = new DataInputStream(socket.getInputStream());
                DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

                // Perform handshake and send the response
                outputStream.writeUTF("Handshake successful!");

                // Create a new thread for handling the client request
                executorService.execute(new SocketHandler(inputStream, outputStream));
            }
        }
    }

    static class SocketHandler implements Runnable {
        private DataInputStream inputStream;
        private DataOutputStream outputStream;

        public java_24752_SocketServer_A07(DataInputStream inputStream, DataOutputStream outputStream) {
            this.inputStream = inputStream;
            this.outputStream = outputStream;
        }

        @Override
        public void run() {
            try {
                // Read message from client
                String message = inputStream.readUTF();
                System.out.println("Received message: " + message);

                // Send a response back to client
                outputStream.writeUTF("Successfully received message!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}