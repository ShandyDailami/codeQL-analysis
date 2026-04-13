import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class java_41131_SocketServer_A01 {
    public static void main(String[] args) throws IOException {
        SSLServerSocket serverSocket = (SSLServerSocket) new SSLServerSocket(5000);
        System.out.println("Server started.");

        while (true) {
            SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
            System.out.println("Client connected.");

            // Create a new thread for each client
            new ClientHandler(clientSocket).start();
        }
    }

    static class ClientHandler extends Thread {
        private final SSLSocket socket;

        public java_41131_SocketServer_A01(SSLSocket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();

                // Send a greeting message to the client
                String greeting = "Hello, client!";
                outputStream.write(greeting.getBytes());

                // Receive and echo back the client's message
                byte[] buffer = new byte[1024];
                int bytesRead = inputStream.read(buffer);
                if (bytesRead > 0) {
                    String message = new String(buffer, 0, bytesRead);
                    System.out.println("Received: " + message);
                    outputStream.write(message.getBytes());
                }

                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}