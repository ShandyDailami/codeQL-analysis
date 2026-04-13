import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_14605_SocketServer_A03 {

    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server is running on port " + PORT);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected");
                new HandleClientThread(socket).start();
            }
        } finally {
            serverSocket.close();
        }
    }
}

class HandleClientThread extends Thread {
    private final Socket socket;

    public java_14605_SocketServer_A03(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Here you can handle the client connection and perform operations
            // that are security-sensitive to A03_Injection, for example:
            // 1. Reading from the client
            // 2. Sending a response back to the client
            // 3. Etc.
        } finally {
            socket.close();
        }
    }
}