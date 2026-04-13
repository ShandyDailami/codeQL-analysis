import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_11075_SocketServer_A08 {
    private int port;
    private ServerSocket serverSocket;

    public java_11075_SocketServer_A08(int port) {
        this.port = port;
        try {
            this.serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            System.out.println("Could not listen on port " + port + ".");
            System.exit(-1);
        }
    }

    public void startServer() {
        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Accepted new connection from " + clientSocket.getRemoteSocketAddress());

                // Here you can handle the client connection and send messages.
                // For the security sensitive operation related to A08_IntegrityFailure, you can use SSL/TLS to secure the connection.

                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    public static void main(String[] args) {
        new SocketServer(8080).startServer();
    }
}