import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_37527_SocketServer_A03 {
    private static final int DEFAULT_PORT = 12345;
    private static final String DEFAULT_SERVER_MESSAGE = "Server: Hello Client!";

    private int port;
    private String serverMessage;

    public java_37527_SocketServer_A03() {
        this(DEFAULT_PORT, DEFAULT_SERVER_MESSAGE);
    }

    public java_37527_SocketServer_A03(String serverMessage) {
        this(DEFAULT_PORT, serverMessage);
    }

    public java_37527_SocketServer_A03(int port) {
        this(port, DEFAULT_SERVER_MESSAGE);
    }

    public java_37527_SocketServer_A03(int port, String serverMessage) {
        this.port = port;
        this.serverMessage = serverMessage;
    }

    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server started at port " + port);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected from " + clientSocket.getRemoteSocketAddress());

            // Sending server message to client
            clientSocket.getOutputStream().write(serverMessage.getBytes());

            // Receiving client message
            byte[] bytes = new byte[1024];
            clientSocket.getInputStream().read(bytes);
            System.out.println("Received message: " + new String(bytes));

            clientSocket.close();
        }
    }

    public static void main(String[] args) {
        SocketServer server = new SocketServer("Hello from the server!");
        try {
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}