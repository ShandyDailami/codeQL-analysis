import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_33777_SocketServer_A08 {
    private int port;
    private boolean listening;

    public java_33777_SocketServer_A08(int port) {
        this.port = port;
        this.listening = false;
    }

    public void start() throws IOException {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(port);
            this.listening = true;
            System.out.println("Server started on port " + port + ".");

            while (this.listening) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // You can put your server logic here
                // For example, you can send a message back to the client
                // String message = "Hello, client!";
                // byte[] bytes = message.getBytes();
                // OutputStream out = socket.getOutputStream();
                // out.write(bytes);
            }

            serverSocket.close();
        } catch (IOException e) {
            serverSocket.close();
            System.out.println("Failed to listen on port " + port);
            e.printStackTrace();
        }
    }

    public void stop() {
        this.listening = false;
    }

    public static void main(String[] args) {
        SocketServer server = new SocketServer(12345);

        // Start the server
        try {
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}