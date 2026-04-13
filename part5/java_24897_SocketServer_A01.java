import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_24897_SocketServer_A01 {
    private int port;
    private ServerSocket serverSocket;

    public java_24897_SocketServer_A01(int port) {
        this.port = port;
    }

    public void start() {
        try {
            serverSocket = new ServerSocket(port);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected");

                // Here you can use thread to handle communication
                new SecureSocketHandler(clientSocket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new SecureSocketServer(5000).start();
    }
}

class SecureSocketHandler extends Thread {
    private Socket socket;

    public java_24897_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // Handle communication here
    }
}