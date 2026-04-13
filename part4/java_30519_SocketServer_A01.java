import java.net.Socket;
import java.net.ServerSocket;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class java_30519_SocketServer_A01 {

    private int port;
    private ServerSocket serverSocket;
    private boolean running = false;

    public java_30519_SocketServer_A01(int port) {
        this.port = port;
    }

    public void startServer() {
        if (running) return;
        running = true;

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server started on port: " + port);
            while (true) {
                handleClient(serverSocket.accept());
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to start server.");
        } finally {
            running = false;
            stopServer();
        }
    }

    private void stopServer() {
        try {
            serverSocket.close();
            System.out.println("Server stopped.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to stop server.");
        }
    }

    private void handleClient(Socket socket) {
        try {
            InputStream input = socket.getInputStream();
            OutputStream output = socket.getOutputStream();

            byte[] bytes = new byte[1024];
            int length = input.read(bytes);

            if (length < 0) return;

            String message = new String(bytes, 0, length);
            System.out.println("Received: " + message);

            output.write("Hello Client!".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Failed to handle client.");
        }
    }

    public static void main(String[] args) {
        SocketServer server = new SocketServer(8080);
        server.startServer();
    }
}