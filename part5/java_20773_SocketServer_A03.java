import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_20773_SocketServer_A03 {
    private int port;
    private ServerSocket serverSocket;

    public java_20773_SocketServer_A03(int port) {
        this.port = port;
        startServer();
    }

    private void startServer() {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started on port: " + port);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected from: " + socket.getRemoteSocketAddress());
                // here you can handle the socket and communicate with the client
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        new SocketServer(1234);
    }
}