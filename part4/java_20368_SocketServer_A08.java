import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_20368_SocketServer_A08 {
    private static final int PORT = 4445;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started. Waiting for client connection...");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");

            // Here you can perform operations related to security, like checking the integrity of the client's message.
            // For simplicity, let's just let the client connect and wait for further commands.
            new Handler(socket).start();
        }
    }
}

class Handler extends Thread {
    private Socket socket;

    public java_20368_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        // Perform operations related to the socket here.
        // For example, you can read data from the socket, send data back to the client, or handle errors.
    }
}