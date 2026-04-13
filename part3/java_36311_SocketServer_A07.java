import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_36311_SocketServer_A07 {
    private static final String SSL_PORT = "8443";
    private static SSLServerSocket serverSocket;

    public static void main(String[] args) throws IOException {
        SSLServerSocketFactory sslServerSocketFactory =
                (SSLServerSocketFactory) SSLServerSocket.getDefaultSSLServerSocketFactory();
        serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(Integer.parseInt(SSL_PORT));
        serverSocket.setNeedClientAuth(true);

        while (true) {
            SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
            System.out.println("Client connected");

            // Start the thread for handling the client
            new ClientHandler(clientSocket).start();
        }
    }

    static class ClientHandler extends Thread {
        private final SSLSocket clientSocket;

        ClientHandler(SSLSocket clientSocket) {
            this.clientSocket = clientSocket;
        }

        @Override
        public void run() {
            try {
                SSLSession sslSession = clientSocket.getSession();
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                // Start receiving data
                String request;
                while ((request = in.readLine()) != null) {
                    System.out.println("Received: " + request);

                    // Perform authentication failure
                    if ("authFailure".equals(request)) {
                        out.println("AuthFailure: Invalid username or password");
                    } else {
                        out.println("Unknown request");
                    }

                    out.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}