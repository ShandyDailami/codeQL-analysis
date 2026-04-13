import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_10286_SocketServer_A07 {
    private static final int PORT = 9876;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server started, waiting for connections on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("New connection accepted from " + socket.getRemoteSocketAddress());

                // Create a new thread for each accepted connection
                new ServerThread(socket).start();
            }
        } catch (IOException ex) {
            System.out.println("IOException occurred: " + ex.getMessage());
        }
    }
}

class ServerThread extends Thread {
    private Socket socket;

    public java_10286_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Here, we'll use SSLSocket for secure communication
            SSLSocket sslSocket = (SSLSocket) socket.getSocket();

            // Enable SSL on the socket
            sslSocket.setEnabledSSLSockets(true);
            sslSocket.startHandshake();

            // Here, we'll check the authentication using SSLSocket.getSession()
            SSLSession session = sslSocket.getSession();

            // We'll only accept connections if the session is SSLSession
            if (session == null || !session.isValidated()) {
                System.out.println("Invalid SSLSession, closing connection");
                sslSocket.close();
                return;
            }

            // Now, we can read from and write to the socket
            // ...

            // Remember to close the socket
            sslSocket.close();
        } catch (IOException ex) {
            System.out.println("IOException occurred: " + ex.getMessage());
        }
    }
}