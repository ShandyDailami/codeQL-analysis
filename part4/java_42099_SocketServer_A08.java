import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_42099_SocketServer_A08 {
    private ServerSocket serverSocket;

    public java_42099_SocketServer_A08(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public void startServer() throws IOException {
        System.out.println("Server is listening on port " + serverSocket.getLocalPort());
        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Accepted a new client from " + clientSocket.getRemoteSocketAddress());

            // Create a new thread for each client
            HandlerThread handlerThread = new HandlerThread();
            handlerThread.startHandler(clientSocket);
        }
    }

    public static void main(String[] args) throws IOException {
        EchoServer server = new EchoServer(5000);
        server.startServer();
    }
}