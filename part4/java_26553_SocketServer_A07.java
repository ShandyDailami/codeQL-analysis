import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;

public class java_26553_SocketServer_A07 {

    private static final String PASSWORD = "password";
    private static final String USERNAME = "user";

    private final int port;
    private final ExecutorService executor;

    public java_26553_SocketServer_A07(int port) {
        this.port = port;
        this.executor = Executors.newFixedThreadPool(10);
    }

    public void start() throws IOException {
        SSLServerSocket serverSocket = null;
        try {
            serverSocket = (SSLServerSocket) new SSLServerSocket(port);
            serverSocket.setNeedClientAuth(true);

            System.out.println("Waiting for client authentication");

            SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
            System.out.println("Client authenticated successfully");

            clientSocket.setNeedClientAuth(true);

            // read from and write to the client
            handle(clientSocket.getInputStream(), clientSocket.getOutputStream());
        } finally {
            serverSocket.close();
        }
    }

    private void handle(InputStream input, OutputStream output) {
        executor.execute(new SocketHandler(input, output));
    }

    private static class SocketHandler implements Runnable {
        private final InputStream input;
        private final OutputStream output;

        public java_26553_SocketServer_A07(InputStream input, OutputStream output) {
            this.input = input;
            this.output = output;
        }

        @Override
        public void run() {
            // read from the client
            byte[] bytes = new byte[1024];
            int length;
            try {
                while ((length = input.read(bytes)) != -1) {
                    // handle the received data
                    System.out.println(new String(bytes, 0, length));

                    // write to the client
                    output.write(bytes, 0, length);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new SecureServer(4445).start();
    }
}