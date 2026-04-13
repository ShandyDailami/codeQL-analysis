import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

public class java_22800_SocketServer_A08 {
    public static void main(String[] args) throws IOException {
        // Set up SSL Server
        SSLServerSocket sslServerSocket = null;
        try {
            sslServerSocket = (SSLServerSocket) new SSLServerSocket(8080, (SSLServerSocket) null, true, true);
            sslServerSocket.setNeedClientAuth(true);
        } catch (IOException e) {
            System.err.println("Could not setup SSL Server. Quitting.");
            System.exit(1);
        }

        // Set up server
        ServerSocket serverSocket = (ServerSocket) sslServerSocket.accept();
        System.out.println("Accepted connection from " + serverSocket.getInetAddress().getHostAddress());

        // Handle connections in a thread-safe way
        Thread serverThread = new Thread(new ServerThread(serverSocket));
        serverThread.start();
    }
}

class ServerThread implements Runnable {
    private final ServerSocket serverSocket;

    public java_22800_SocketServer_A08(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    @Override
    public void run() {
        try {
            while (true) {
                SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
                System.out.println("Accepted connection from " + clientSocket.getRemoteSocketAddress());

                // Setup input and output streams
                try (InputStream input = clientSocket.getInputStream(); OutputStream output = clientSocket.getOutputStream()) {
                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    while ((bytesRead = input.read(buffer)) != -1) {
                        output.write(buffer, 0, bytesRead);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}