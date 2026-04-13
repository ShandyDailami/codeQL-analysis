import java.io.*;
import java.net.*;
import javax.net.ssl.*;

public class java_36721_SocketServer_A07 {
    private static final String SSL_PROTOCOL = "SSL";
    private static final String SERVER_SOCKET_HOST = "localhost";
    private static final int SERVER_SOCKET_PORT = 4444;

    public static void main(String[] args) throws Exception {
        Socket socket = null;

        try {
            SSLServerSocket sslServerSocket = (SSLServerSocket) SSLServerSocketFactory.createServerSocket(SERVER_SOCKET_PORT, null, SSL_PROTOCOL, true);
            sslServerSocket.setNeedClientAuth(true);

            System.out.println("Server is listening on port " + sslServerSocket.getLocalPort());

            while (true) {
                socket = sslServerSocket.accept();
                System.out.println("Client " + socket.getRemoteSocketAddress() + " connected");

                // Start new thread for handling this client
                new ClientHandler(socket).start();
            }
        } finally {
            if (socket != null) {
                socket.close();
            }
        }
    }

    private static class ClientHandler extends Thread {
        private final Socket socket;
        private final SSLServerSocket serverSocket;

        public java_36721_SocketServer_A07(Socket socket) {
            this.socket = socket;
            this.serverSocket = (SSLServerSocket) socket.getServerSocket();
        }

        @Override
        public void run() {
            try {
                SSLSocket sslSocket = (SSLSocket) serverSocket.accept();

                System.out.println("Client " + sslSocket.getRemoteSocketAddress() + " connected");

                // Process the request from the client
                InputStream inputStream = sslSocket.getInputStream();
                OutputStream outputStream = sslSocket.getOutputStream();

                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                PrintWriter writer = new PrintWriter(outputStream, true);

                String request;
                while ((request = reader.readLine()) != null) {
                    System.out.println("Received request: " + request);
                    writer.println("Response from server: " + request);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}