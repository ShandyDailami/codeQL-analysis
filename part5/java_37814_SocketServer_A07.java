import java.net.*;
import java.io.*;
import java.util.concurrent.*;

public class java_37814_SocketServer_A07 {
    private static final String SSL_KEYSTORE = "keystore.jks";
    private static final String SSL_KEYSTORE_PASSWORD = "password";
    private static final String SSL_TRUSTSTORE = "truststore.jks";
    private static final String SSL_TRUSTSTORE_PASSWORD = "password";

    private static ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(4444);
            System.out.println("Server is listening on port 4444");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");
                Handler handler = new Handler(socket);
                executorService.execute(handler);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }

    private static class Handler implements Runnable {
        private Socket socket;

        public java_37814_SocketServer_A07(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();

                // Read the client's certificate
                Certificate certificate = SSLUtils.readCertificate(inputStream);

                // Verify the client's certificate
                boolean isValid = SSLUtils.verifyCertificate(certificate, SSL_TRUSTSTORE, SSL_TRUSTSTORE_PASSWORD);

                if (!isValid) {
                    System.out.println("Authentication failed");
                    outputStream.write("Authentication failed\n".getBytes());
                    outputStream.close();
                    return;
                }

                // Authentication successful, proceed with communication
                outputStream.write("Authentication successful\n".getBytes());
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}