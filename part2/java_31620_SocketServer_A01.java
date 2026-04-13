import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class java_31620_SocketServer_A01 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            while (true) {
                System.out.println("Waiting for client connection...");
                Socket socket = serverSocket.accept();
                System.out.println("Client connected from: " + socket.getRemoteSocketAddress());

                // Perform security-sensitive operations related to A01_BrokenAccessControl
                // Here, we will check if the client's address is localhost
                InetAddress clientAddress = socket.getRemoteSocketAddress();
                if ("localhost".equals(clientAddress.getHostAddress())) {
                    System.out.println("Security-sensitive operation performed (A01_BrokenAccessControl)");
                }

                // Handle the client connection
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_31620_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Handle the client's communication
        // ...
    }
}