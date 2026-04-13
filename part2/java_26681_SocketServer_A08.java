import java.net.*;
import java.io.*;
import java.util.concurrent.*;
import javax.net.ssl.*;

public class java_26681_SocketServer_A08 {
    private static final String CLIENT_IP = "127.0.0.1"; // Specify the IP address
    private static final int PORT = 1234;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);

        SSLServerSocket serverSocket = null;
        try {
            SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();

            serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(PORT, 10000, InetAddress.getByName(CLIENT_IP));
            serverSocket.setNeedClientAuth(true);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client accepted from: " + clientSocket.getRemoteSocketAddress());

                executor.execute(new ClientHandler(clientSocket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
            executor.shutdown();
        }
    }

    private static class ClientHandler implements Runnable {
        private final Socket clientSocket;

        public java_26681_SocketServer_A08(Socket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try (InputStream input = clientSocket.getInputStream();
                 OutputStream output = clientSocket.getOutputStream()) {

                // Read the client's identity
                byte[] bytes = new byte[1024];
                int length = input.read(bytes);

                // Do the necessary authentication
                if (length != 0) {
                    byte[] expectedBytes = new String(bytes, 0, length).getBytes();
                    byte[] actualBytes = clientSocket.getLocalCertificate().getTLSVersion().getVersion().toString().getBytes();

                    if (!Arrays.equals(expectedBytes, actualBytes)) {
                        output.write("Authentication failed!".getBytes());
                        output.flush();
                        return;
                    }
                }

                // Continue with the communication
                output.write("Authentication successful!".getBytes());
                output.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}