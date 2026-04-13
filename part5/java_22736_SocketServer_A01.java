import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;
import java.net.SocketException;

public class java_22736_SocketServer_A01 {
    private int port;
    private ServerSocket serverSocket;

    public java_22736_SocketServer_A01(int port) {
        this.port = port;
        try {
            serverSocket = new ServerSocket(port, 100, null); // 100 is the backlog parameter
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }
    }

    public void startServer() {
        System.out.println("Server started on port: " + port);

        while (true) {
            try {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getRemoteSocketAddress());

                // Here, we could add code to handle secure client communication
                // For example, we could use SSLSocket for the communication

                // For simplicity, we'll just close the connection here
                clientSocket.close();
            } catch (SocketException e) {
                System.out.println("SocketException encountered.");
            } catch (IOException e) {
                System.out.println("IOException in server");
            }
        }
    }

    public static void main(String[] args) {
        new SecureSocketServer(8000).startServer();
    }
}