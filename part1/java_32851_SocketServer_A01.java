import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_32851_SocketServer_A01 {
    private static final int PORT = 9876;
    private ServerSocket serverSocket;

    public java_32851_SocketServer_A01() {
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server started on port " + PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startServer() {
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected from " + socket.getRemoteSocketAddress());

                // Here, we are opening the socket for both reading and writing, but we don't implement any security measures.
                // In a real-world scenario, you would want to implement authentication and encryption to protect the connection.
                new ClientHandler(socket).start();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Client disconnected");
            }
        }
    }

    public static void main(String[] args) {
        new SocketServer().startServer();
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_32851_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        // Here, we are just reading and echoing back any message received from the client.
        // In a real-world scenario, you would want to implement a more complex protocol or security mechanism.
        try {
            while ((socket.getInputStream().read()) != -1) {
                socket.getOutputStream().write(socket.getInputStream().read());
                socket.getOutputStream().flush();
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}