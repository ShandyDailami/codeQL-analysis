import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_12681_SocketServer_A03 {
    private static final int DEFAULT_PORT = 1234;
    private ServerSocket serverSocket;

    public java_12681_SocketServer_A03() throws IOException {
        this.serverSocket = new ServerSocket(DEFAULT_PORT);
    }

    public void startServer() {
        System.out.println("Server is running on port: " + DEFAULT_PORT);
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getRemoteSocketAddress());
                DataInputStream in = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                String message = in.readUTF();
                System.out.println("Received message: " + message);
                out.writeUTF("Server received your message: " + message);
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Client disconnected");
            }
        }
    }

    public static void main(String[] args) throws IOException {
        SocketServer server = new SocketServer();
        server.startServer();
    }
}