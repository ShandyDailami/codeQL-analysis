import javax.net.ssl.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class java_26355_SocketServer_A07 {

    private final SSLServerSocket serverSocket;
    private SSLSocket clientSocket;

    public java_26355_SocketServer_A07(int port) throws IOException {
        SSLServerSocketFactory sslServerSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(port);
        serverSocket.setNeedClientAuth(true);
    }

    public void start() throws IOException {
        while (true) {
            clientSocket = serverSocket.accept();
            clientSocket.setNeedClientAuth(true);
            System.out.println("Client connected");

            // Start thread to handle client
            new ClientHandler(clientSocket).start();
        }
    }

    private class ClientHandler extends Thread {
        private final Socket clientSocket;
        private final SSLConnection connection;

        public java_26355_SocketServer_A07(Socket socket) throws IOException {
            this.clientSocket = socket;
            SSLSocketFactory sslSocketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            connection = (SSLConnection) sslSocketFactory.createConnection(clientSocket, serverSocket);
            connection.setNeedServerAuth(true);
        }

        @Override
        public void run() {
            try {
                InputStream inputStream = connection.getInputStream();
                while ((inputStream.read()) != -1) {}
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        try {
            new SecureSocketServer(8443).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}