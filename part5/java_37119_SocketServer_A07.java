import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_37119_SocketServer_A07 {
    private static final int PORT = 5000;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            while (true) {
                Socket socket = server.accept();
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_37119_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Here you can implement your authentication logic.
            // For simplicity, we'll just check if the client's name is "Admin".
            String clientName = socket.getInetAddress().getHostName();
            if ("Admin".equals(clientName)) {
                System.out.println("Authorized client: " + clientName);
            } else {
                System.out.println("Failed authentication for client: " + clientName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}